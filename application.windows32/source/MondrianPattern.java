import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import com.hamoid.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class MondrianPattern extends PApplet {




VideoExport videoExport;
int number = 250;
PVector SquareRange = new PVector(20.0f, 80.0f);

public void setup(){
  
  
  //frameRate(10);
  videoExport = new VideoExport(this, "Mondrian.mov");
  videoExport.setFrameRate(10);  
  videoExport.startMovie();
}

int time_frame = 0; 
public void draw(){
  background(0);
  for(int i=0; i<number; i++){
    int rnd_Rcolor = (int)random(256);
    int rnd_Gcolor = (int)random(256);
    int rnd_Bcolor = (int)random(256);
    int rnd_width = (int)random(SquareRange.x, SquareRange.y);
    int rnd_x = (int)random(width);
    int rnd_y = (int)random(height);
    fill(rnd_Rcolor,rnd_Gcolor,rnd_Bcolor);
    rect(rnd_x, rnd_y, rnd_width, rnd_width);
  }
  videoExport.saveFrame();
  time_frame +=1;
  if(time_frame > 600){
    videoExport.endMovie();
    exit();
  }
}
  public void settings() {  size(512,512); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "MondrianPattern" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
