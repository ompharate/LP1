
#include <DHT.h>
#define DHTPIN 2
#define DHTTYPE DHT11 // DHT 11 sensor
// Define LED pin
#define LED_PIN 13 // Use built-in LED on Arduino Uno (pin 13)
    DHT dht(DHTPIN, DHTTYPE);
void setup()
{
    Serial.begin(9600);
    dht.begin();

    pinMode(LED_PIN, OUTPUT); // Initialize LED pin as an output
}
void loop()
{
    delay(2000); // Wait for sensor to stabilize
    // Read humidity and temperature
    float humidity = dht.readHumidity();
    float temperature = dht.readTemperature();
    // Check if any reads failed and exit early (to try again).
    if (isnan(humidity) || isnan(temperature))
    {
        Serial.println("Failed to read from DHT sensor!");
        return;
    }
    // Print humidity and temperature to Serial Monitor
    Serial.print("Humidity: ");
    Serial.print(humidity);
    Serial.print(" %\t");
    Serial.print("Temperature: ");
    Serial.print(temperature);
    Serial.println(" °C");
    // Check if temperature exceeds 26°C
    if (temperature > 26.0)
    {
        digitalWrite(LED_PIN, HIGH); // Turn on the LED
    }
    else
    {
        digitalWrite(LED_PIN, LOW); // Turn off the LED
    }
}