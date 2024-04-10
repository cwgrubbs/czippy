from flask import Flask
from spleeter_separator import SpleeterSeparator

app = Flask(__name__)


@app.route('/')
def hello_geek():
    return '<h1>Hello from Flask & Docker</h1>'


@app.route('/separate')
def separate():
    separator = SpleeterSeparator


if __name__ == "__main__":
    app.run(debug=True)
