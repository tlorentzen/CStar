
const int button = A0;
const int topRed = 8;
const int middleRed = 11;
const int middleGreen = 10;
const int bottomGreen = 4;

long int blinkSpeed = 100;
int blinkTime = 10;
int colorState = 2;
bool start;

void setup() {
  pinMode(button, INPUT);
  pinMode(topRed, OUTPUT);
  pinMode(middleRed, OUTPUT);
  pinMode(middleGreen, OUTPUT);
  pinMode(bottomGreen, OUTPUT);
  Serial.begin(9600);

}

void loop() {
  unsigned int buttonState = analogRead(button);
  if(buttonState != 0){
    changeLight();
    delay(300);
  }
}

void changeLight(){
  if(colorState == 0){
    analogWrite(topRed, 0);
    analogWrite(middleRed, 255);
    analogWrite(middleGreen, 70);
    colorState = 1;
  }
  else if (colorState == 1){
    analogWrite(middleRed, 0);
    analogWrite(middleGreen, 0);
    analogWrite(bottomGreen, 255);
    greenBlink();
    colorState = 2;
    }
  else{
    analogWrite(bottomGreen, 0);
    analogWrite(topRed, 255);
    colorState = 0;
  }
}

void greenBlink(){
  unsigned int buttonState = analogRead(button);
  Serial.println(buttonState);
  start = true;
  delay(300);
  
  while(buttonState == 0 || start == true){
    buttonState = analogRead(button);
    analogWrite(bottomGreen, 0);
    delay(blinkSpeed);
    analogWrite(bottomGreen, 255);
    delay(blinkSpeed);
    start = false;
  }
}
