import java.util.Scanner;
import java.io.*;
public class EscapetheSpire
{
    private short x = -1;
    private short wepon = -1;
    private boolean gotgems=false;
    public EscapetheSpire()
    {
        try{
            FileReader reader = new FileReader("endingsFound");
            BufferedReader buffer = new BufferedReader(reader);
            String str = buffer.readLine();           
        }
        catch(FileNotFoundException e){
            try{createFile();}
            catch(IOException f){}
        }
        catch(IOException e){}
        start();
    }
    private void start(){
        System.out.println("to choose an answer, type the number that appears next to it");
        System.out.println("your imprisoned at the top of a tall spire. outside you cell is a sleeping guard and the window looks like you can\n"+
        "just barely slip through the bars but you know one thing you must escape\n"+
        "1 wake and bribe guard\n2 slip through bars on window\n3 try to get through the cell bars");
        x=getInput(3);
        if(x==1){bribe();}
        else if(x==2){windowexit();}
        else{cellbars();}
    }
    private void bribe(){
        System.out.println("you wake up the guard and offer him lots of money and he laughs,tells you about a rusty bar,waves to a door,ad goes back to sleep");
        armory();
    }
    private void cellbars(){
        System.out.println("Lucky you found a little to rusty bar and broke it off silently.The guard stirs, opens his eyes, and sees "+
        "you atempting to escape\nHe waves to a door and goes back to sleep. you then go through the door he mentioned");
        armory();
    }
    private void windowexit(){
        System.out.println("once you get out you are standing on a thin ledge.you see dozens of archers and crossbowman taking aim at you\n"+
        "1 jump\n2 go back in\n3 run around");
        x=getInput(3);
        if(x==1){ending1();}
        else if(x==2){start();}
        else{runaroundtop();}
    }
    private void runaroundtop(){
        System.out.println("arrows and bolts start wizzing by you as you run.You see a trapdoor on the floor\n"+
        "1 go through\n2 jump\n3 keep runing");
        x=getInput(3);
        if(x==1){armory();}
        else if(x==2){System.out.println("you leap from the tower as arrows pass by your head at high speeds till SPLAT your nothing but a big bloody mess on the ground");
        ending1();}
        else{windowexit();}
    }
    private void armory(){
        System.out.println("your in an armory and you can see many wepons and a spellbook\n"+
        "1 take sword and sheild\n2 take spear\n3 take the spellbook");
        x=getInput(3);
        if(x==1){wepon = 0;System.out.println("you know nothing of magic and the spear is just to big so you just grab these");}
        else if(x==2){wepon = 1;System.out.println("it seems a little big at first but a shinks to the perfect size when you pick it up.handy");}
        else{
            wepon = 2;
            System.out.println("when you pick up the spellbook magical knowledge flow into you you put it back down then forget everything\n"+
            "so you pick it up and take it with you");
        }
        lockeddoor();
    }
    private void lockeddoor(){
        System.out.println("you come across a locked door and you can see through the grate,hanging on the wall just out of reach are the keys\n");
        if(wepon==0){System.out.println("if only ou had one of those other wepons but you dont so you keep going");}
        else if(wepon==1){System.out.println("you stick the spear through and grab the keys on the end");}
        else{System.out.println("you know a spell that can create a floting spectral hand and cast it to bring the keys to you");}
        if(wepon!=0){System.out.println("go through the door\n1 yes\n2 no");x=getInput(2);
            if(x==1){throughthelockeddoor();}
            else{downthehall();}
        }
        else{downthehall();}
    }
    private void downthehall(){
        System.out.println("you come across the double spiral staircase and start going down.You hear shouting from above and relize that they found out ou where gone\n"+
        "1 jump down center of staircase\n2 go through conviniently placed door next to you\n3 run down faster");
        x=getInput(3);
        if(x==1){stairwelljump();}
        else if(x==2){dukeschamber();}
        else{System.out.println("you run down as fast as you can and fight off the few guards that get to you pretty quickly.at the bottom is a door you go through");bottomofstairs();}
    }
    private void stairwelljump(){
        if(wepon==0){System.out.println("you jump and hit the ground way to hard breaking every bone in your legs.\n"+
            "as you lay there bleeding out you think if you only brought the spear or spellbook");ending2();}
        else if(wepon==1){System.out.println("you jump and stick the spear on the railings on both starways to try and slow your fall\n"+
            "all it does however is make you spin realy fast and you puke multiple time till you hit the ground like a bullet");ending3();}
        else{System.out.println("you jump and cast a slowfall spell on yourself and get down safely and exit the only door");bottomofstairs();}
    }
    
    private void throughthelockeddoor(){
        System.out.println("you are amazed at the piles of gold and gems that lay before you");
        if(wepon==1){System.out.println("you start shoving as much gold and gems in your clothes as you can.");}
        else{System.out.println("you reconize many of the gems as once needed for powerful spells so you stuff your clothes full then\n"+
            "take another a cast a teleportation spell on the rest to send it to your home\n"+
            " before you relize you dont have another gem to teleport yourself.oh well");}
        gotgems=true;
        dukeschamber();
    }
    private void dukeschamber(){
        System.out.println("you go through the a door and find yourself in a large bedroom and hear the duke in the bathroom\n"+
        "1 run\n2 hide\n3 kill him");
        x=getInput(3);
        if(x==1){System.out.println("you run out of the room and down the stairs as fast as ou can");bottomofstairs();}
        else if(x==2){hide();}
        else{kill();}
    }
    private void hide(){
        System.out.println("1 under bed\n2 in closet");
        x=getInput(2);
        System.out.println("the duke comes out of the bathroom and screams\"WHAT IS THAT AWFUL STENCH GUARDS FIND IT\"");
        if(x==1){System.out.println("the guards rush in and start looking around and suddenly you are impaled by a spear so much for that");ending4();}
        else{System.out.println("the guards rush in and start looking one opens the door,sees you,and sushes you.He closes the door and states\n"+
            "\"not in here.\"you wait till everyone leaves and exit the room,go down the stairs,and walk outside");bottomofstairs();}
    }
    private void kill(){
        if(wepon==0){System.out.println("before he notices you his head is already rolling on the floor.feeling satisfied you exit the tower");}
        else if(wepon==1){System.out.println("you stab him through the chest with your spear and he scream bloody murder and dies\n"+
            "guards come rushing in and see yuo standing over his dead body and cheer for you.they pick you up and parade you through\n"+
            "the steets, happy that you finaly killed that tyrant");ending5();}
        else{System.out.println("you cast a simple death curse upon the duke and he drops dead instantly");
            if(gotgems){
                System.out.println("you suddenly think of something awesome and pull out a large diamond from your pocket.you begin a short\n"+
                "ritual to bring back the duke as your undead servent and send him onto the balcony and make him yell that ou are free to go\n"+
                "you walk out the front gate as if you own the place and go home");ending6();
            }
        }
    }
    private void bottomofstairs(){
        System.out.println("you get outside and see the gate closing\n1run to gate\n2 find another way out");
        x=getInput(2);
        if(x==1){gate();}
        else{otherwayout();}
    }
    private void gate(){
        if(wepon==0){System.out.println("20 feet from the gate you throw your sheild so that it holds open the gate and you slide under it \n"+
            "and grab your sheild on the way out.Your home free.you run into the wood and are never seen again");ending7();}
        else if(wepon==1){
            System.out.println("20 feet from the gate you throw your spear at the gatekeeper impaleing him instantly killing him\n"+
            "you crawl through the small gap at the bottom of the gate and high tail it out of there back home");ending8();
        }
        else{
            System.out.println("you cast a spell of supreame strength and you simply walk to the gate and punch it off its hinges sending it flying for miles\n"+
            "and nobody ever bothers you again");
            ending9();
        }
    }
    private void otherwayout(){
        
        if(wepon==0){System.out.println("as you run around the perimeter of the fortress you cant find anything when sudenly you feel a sharp pain\n"+
            "in your leg and look down to see an arrow sticking out of it.3 seconds later and about 30 more arrows and bolts peirce your skin");ending10();}
        else if(wepon==1){System.out.println("you look at the spear in our hand and remember how it shrunk when you grabed it so you try to make it\n"+
            "slightlly bigger and it works nicely.so you go and run right at the wall and stuff the spear into the ground and make it to ten times its size\n"+
            "launch yourself high over the wall and land perfectly.you then run away to another country and call yourself armando");ending11();}
        else{
            if(gotgems){
                System.out.println("because you still have those gems you took you have the perfect materials for your most powerful spells\n"+
                "there are lots of explosions as arrows bounce off you.soldiers come and slice you with their sword\n"+
                "but they melt as soon as they touch you.its a massacre as you kill everyone but when your done you simply go home");ending12();
            }
            else{
                System.out.println("you dont have a way out without useing THAT magic,so you cut your hand and start useing blood magic\n"+
                "you quickly and effortlessly kill every guard in the casle but before you know you have no blood left in your body \n"+
                "and die of oxygen deprivation");ending13();
            }
        }
    }
    //all ending checks
    private void ending1(){
        if(read(1).equals("f")){try{endingFound(1);}
        catch(IOException e){}System.out.println("new ending found: learn to fly");}
        else{System.out.println("ending already found");}
        startover();
    }
    private void ending2(){
        if(read(2).equals("f")){try{endingFound(2);}
        catch(IOException e){}System.out.println("new ending found:Floor stain");}
        else{System.out.println("ending already found");}
        startover();
    }
    private void ending3(){
        if(read(3).equals("f")){try{endingFound(3);}
        catch(IOException e){}System.out.println("new ending found:bullet into the ground");}
        else{System.out.println("ending already found");}
        startover();
    }
    private void ending4(){
        if(read(4).equals("f")){try{endingFound(4);}
        catch(IOException e){}System.out.println("new ending found:The monster under the bed");}
        else{System.out.println("ending already found");}
        startover();
    }
    private void ending5(){
        if(read(5).equals("f")){try{endingFound(5);}
        catch(IOException e){}System.out.println("new ending found:Hero of the people");}
        else{System.out.println("ending already found");}
        startover();
    }
    private void ending6(){
        if(read(6).equals("f")){try{endingFound(6);}
        catch(IOException e){}System.out.println("new ending found:Necromancer");}
        else{System.out.println("ending already found");}
        startover();
    }
    private void ending7(){
        if(read(7).equals("f")){try{endingFound(7);}
        catch(IOException e){}System.out.println("new ending found:Captain Unamedcountry");}
        else{System.out.println("ending already found");}
        startover();
    }
    private void ending8(){
        if(read(8).equals("f")){try{endingFound(8);}
        catch(IOException e){}System.out.println("new ending found:eagle eye");}
        else{System.out.println("ending already found");}
        startover();
    }
    private void ending9(){
        if(read(9).equals("f")){try{endingFound(9);}
        catch(IOException e){}System.out.println("new ending found:wizard smash");}
        else{System.out.println("ending already found");}
        startover();
    }
    private void ending10(){
        if(read(10).equals("f")){try{endingFound(10);}
        catch(IOException e){}System.out.println("new ending found:porcupine");}
        else{System.out.println("ending already found");}
        startover();
    }
    private void ending11(){
        if(read(11).equals("f")){try{endingFound(11);}
        catch(IOException e){}System.out.println("new ending found:pole vault");}
        else{System.out.println("ending already found");}
        startover();
    }
    private void ending12(){
        if(read(12).equals("f")){try{endingFound(12);}
        catch(IOException e){}System.out.println("new ending found:Rich wizard");}
        else{System.out.println("ending already found");}
        startover();
    }
    private void ending13(){
        if(read(13).equals("f")){try{endingFound(13);}
        catch(IOException e){}System.out.println("new ending found:blood type none");}
        else{System.out.println("ending already found");}
        startover();
    }
    private void startover(){
        System.out.println("would you like to startover\n1 yes\n2 no");
        x=getInput(2);
        if(x==1){start();}
    }
    private void createFile() 
    throws IOException {
        String str = "f,f,f,f,f,f,f,f,f,f,f,f,f";
        BufferedWriter writer = new BufferedWriter(new FileWriter("endingsFound"));
        writer.write(str);
        writer.close();
    }
    private String read(int ending){
        String values = "";
        try{
            FileReader reader = new FileReader("endingsFound");
            BufferedReader buffer = new BufferedReader(reader);
            values = buffer.readLine();
        }
        catch(FileNotFoundException e){}
        catch(IOException e){}
        String[] tfs = values.split(",");
        String r = "";
        r=tfs[ending-1];
        return r;
    }
    private void endingFound(int found)
        throws IOException{
        String values = "";
        try{
            FileReader reader = new FileReader("endingsFound");
            BufferedReader buffer = new BufferedReader(reader);
            values = buffer.readLine();
        }
        catch(FileNotFoundException e){}
        catch(IOException e){}
        String[] tfs = values.split(",");
        tfs[found-1]="t";
        String str = String.join(",",tfs);
        BufferedWriter writer = new BufferedWriter(new FileWriter("endingsFound"));
        writer.write(str);
        writer.close();
    }
    private short getInput(int posible){
        short b = input();
        while(!validateInput(b,posible)){
            System.out.println("please enter valid input");
            b = input();
        }
        return b;
    }
    private short input(){
        short b = -1;
        Scanner input = new Scanner(System.in);
        try {
            b = (short)input.nextInt();
        } catch(Exception e)
        {}
        return b;
    }
    private boolean validateInput(short x,int posible){
        if(x <= posible && x > 0)
            return true;
        else
            return false;
    }
}

