
unchangeable pin button = A0;

pin array topLed = [8, -1, -1];
unchangeable pin array middleLed = [11, 10, -1];
unchangeable pin array bottomLed = [-1, 4, -1];


color red = [255, 0, 0];
color green = [0, 255, 0];
color yellow = [255, 70, 0];
color noColor = [0, 0, 0];

big integer blinkSpeed = 100;
integer blinkTime = 10;
integer colorState = 2;
boolean start;

void setup() {
}

void loop() {
  positive integer buttonState = readFrom(button);

  if(buttonState ISNOT 0){
    changeLight();
    sleep(300);
  }
}

void changeLight(){
  if(colorState IS 0){
    topLed = noColor);
    middleLed = yellow);
    colorState = 1;
  }
  if (colorState IS 1){
    middleLed = noColor);
    bottomLed = green);
    greenBlink();
    colorState = 2;
    }
  else{
    bottomLed = noColor);
    topLed = red);
    colorState = 0;
  }
}


void greenBlink(){
  positive integer buttonState = button;
  console.print(buttonState);
  start = true;
  sleep(300);

  while(buttonState IS 0 OR start IS true) repeat{
    buttonState = button;
    bottomLed = [0,0,0];
    sleep(blinkSpeed);
    bottomLed = green);
    sleep(blinkSpeed);
    start = false;
  }
}
