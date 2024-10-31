//Pins are stablished like constants
const int led1Pin = 9;   // Pin LED 1
const int led2Pin = 11;  // Pin LED 2

void setup() {
  // Initializes serial communication at 9600 baud.
  Serial.begin(9600);  
}

void loop() {
//  /Check if there is data in the serial
  if (Serial.available() > 0) {
    //reads up to \n established in java
    String input = Serial.readStringUntil('\n');
    //Convert string to int
    int number = input.toInt();
    Serial.print("Recived number: ");
    Serial.println(number);
    //Now we can use this var to do something like open an especific pin
    switch (number) {
        case 42:
            Serial.println("Enter case 42"); // Java also read this
            digitalWrite(led1Pin, HIGH); // Open LED 1
            delay(5000);
            digitalWrite(led1Pin, LOW); // Close LED 1
            break;
        default:
            Serial.println("Enter case default"); // Java also read this
            digitalWrite(led2Pin, HIGH); // In default case open Led 2
            delay(5000);
            digitalWrite(led2Pin, LOW); //close Led 2
            break;
    }
  }
}
