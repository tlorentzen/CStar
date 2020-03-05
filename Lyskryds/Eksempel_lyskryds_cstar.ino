
unchangeable pin button = A0;

unchangeable pin array topLed = {8, -1, -1};
unchangeable pin array middleLed = {11, 10, -1};
unchangeable pin array bottomLed = {-1, 4, -1};


color red = {255, 0, 0};
color green = {0, 255, 0};
color yellow = {255, 70, 0};
color noColor = {0, 0, 0};

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
    write(topLed, noColor);
    write(middleLed, yellow);
    colorState = 1;
  }
  else if (colorState IS 1){
    write(middleLed, noColor);
    write(bottomLed, green);
    greenBlink();
    colorState = 2;
    }
  else{
    write(bottomLed, noColor);
    write(topLed, red);
    colorState = 0;
  }
}


void greenBlink(){
  positive integer buttonState = read(button);
  console.print(buttonState);
  start = true;
  sleep(300);
  
  while(buttonState IS 0 OR start IS true) repeat{
    buttonState = read(button);
    write(bottomLed, noColor);
    sleep(blinkSpeed);
    write(bottomLed, green);
    sleep(blinkSpeed);
    start = false;
  }
}
