int inFunMode = ;
int valPot1 = ;
int valPot2 = ;
int pinPot1 = A1;
int pinPot2 = A2;
int btnPin = A0;
int btnState = ;
int numOfGraphLeds = ;
int bargraph[] = {, , , , , , , A4, A5, };
int rgb[] = {, , };
void setup(){

}
void loop(){
    if(inFunMode == ){
    readInput();
    setBarGraph();
    setRGB();

}
else{
    makeFun();

}

}
void setBarGraph(){
    int counter = ;
    int barState = map(constrain(valPot1, , ), , , , );
    while(counter < numOfGraphLeds){
    if(barState > counter +  && barState == counter + ){
    bargraph[counter].write();

}
else{
    bargraph[counter].write();

}
    counter = counter + ;

}

}
void readInput(){
    valPot1 = pinPot1.read();
    valPot2 = pinPot2.read();
    btnState = btnPin.read();
    Serial.println(btnState);
    if(btnState > ){
    inFunMode = ;

}

}
void setRGB(){
    int potState = map(constrain(valPot2, , ), , , , );
    if(potState ==  || potState >  && potState <  || potState == ){
    int red = map(potState, , , , );
    writeRGBState(red, , );

}
    if(potState ==  || potState >  && potState <  || potState == ){
    int green = map(potState, , , , );
    writeRGBState(, green, );

}
    if(potState > ){
    int blue = map(potState, , , , );
    writeRGBState(, , blue);

}

}
void writeRGBState(int r, int g, int b){
    rgb[0].write(r);
    rgb[1].write(g);
    rgb[2].write(b);

}
void makeFun(){
    int counter = ;
    int cycle = ;
    int cycles = ;
    while(counter < numOfGraphLeds){
    bargraph[counter].write();
    counter = counter + ;

}
    while(cycle < cycles){
    counter = ;
    while(counter < numOfGraphLeds){
    if(counter < numOfGraphLeds){
    bargraph[counter].write();

}
else{
    bargraph[counter].write();

}
    counter = counter + ;
    delay();

}
    while(counter > ){
    if( counter -  > numOfGraphLeds){
    bargraph[counter].write();

}
else{
    bargraph[counter].write();

}
    counter =  counter - ;
    delay();

}
    cycle = cycle + ;

}
    inFunMode = ;

}
