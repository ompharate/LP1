int irSensorPin = 2;   // Connect the signal pin of the IR sensor to D2
int ledPin = 13;       // Optional LED connected to D13 for indication

void setup() {
  pinMode(irSensorPin, INPUT);  // Set the IR sensor pin as input
  pinMode(ledPin, OUTPUT);      // Set the LED pin as output (optional)
  Serial.begin(9600);           // Begin serial communication for debugging
}

void loop() {
  int objectDetected = digitalRead(irSensorPin);  // Read the IR sensor output

  if (objectDetected == LOW) {
    // Object detected (when the sensor output is LOW)
    Serial.println("Object detected!");
    digitalWrite(ledPin, HIGH);  // Turn on the LED (optional)
  } else {
    // No object detected (when the sensor output is HIGH)
    Serial.println("No object detected.");
    digitalWrite(ledPin, LOW);   // Turn off the LED (optional)
  }

  delay(500);  // Small delay for debounce and stability
}
