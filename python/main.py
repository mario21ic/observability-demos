# These are the necessary import declarations
from opentelemetry import trace
from opentelemetry import metrics

from random import randint
from flask import Flask, request

# Acquire a tracer
tracer = trace.get_tracer(__name__)
# Acquire a meter.
meter = metrics.get_meter(__name__)

# Now create a counter instrument to make measurements with
roll_counter = meter.create_counter(
    "roll_counter",
    description="The number of rolls by roll value",
)

app = Flask(__name__)

@app.route("/demo")
def demo():
    with tracer.start_as_current_span("my_operation") as span:  
        #span = tracer.start_span("my_operation")
        # do operations
        a = 123
        b = 321
        c = (a*b)**2
        d = (a*b)**6
        # set attributes
        span.set_attribute("user", "mair")
        span.set_attribute("op-id", "0x424242")
        span.set_attribute("c", c)
        span.set_attribute("d", d)
        return "Hello"

@app.route("/rolldice")
def roll_dice():
    print("roll_dice starting")
    for x in range(0,100):
        print(x)
    return str(do_roll())

def do_roll():
    #return randint(1, 6)
    # This creates a new span that's the child of the current one
    with tracer.start_as_current_span("do_roll") as rollspan:  
        res = randint(1, 6)
        # set value
        rollspan.set_attribute("roll.value", res)
        # This adds 1 to the counter for the given roll value
        roll_counter.add(1, {"roll.value": res})
        return res

