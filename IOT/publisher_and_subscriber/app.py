from flask import Flask, request, jsonify, render_template

app = Flask(__name__)

data_store = {}

@app.route('/')
def index():
    return render_template('index.html')

@app.route('/publish', methods=['POST'])
def publish():
    content = request.json
    publisher_id = content.get('publisher_id')
    data = content.get('data')
    if not publisher_id or not data:
        return jsonify({'error': 'Invalid input'}), 400
    data_store[publisher_id] = data
    return jsonify({'status': 'success'}), 200

@app.route('/subscribe/<publisher_id>', methods=['GET'])
def subscribe(publisher_id):
    data = data_store.get(publisher_id)
    if data is None:
        return jsonify({'error': 'No data found for this publisher'}), 404
    return jsonify({'data': data}), 200

if __name__ == '__main__':
    app.run(debug=True)


# pip install Flask
# python app.py
