package hello;

import java.io.InputStream;
import java.io.OutputStream;
import javax.microedition.lcdui.*;
import javax.microedition.midlet.MIDlet;
import javax.microedition.io.Connector;
import javax.microedition.io.SocketConnection;



/**
 * @author Kousthub
 */
public class KMM extends MIDlet implements CommandListener, Runnable, ItemStateListener {

    private boolean midletPaused = false;
    
    private SocketConnection sc;
    private InputStream is;
    private OutputStream os;
    private int typed=0;
    private Thread th;
    private Thread t;
    
    //<editor-fold defaultstate="collapsed" desc=" Generated Fields ">//GEN-BEGIN:|fields|0|
    private Command exitCommand;
    private Command okCommand;
    private Form form;
    private TextField t1;
    private StringItem s1;
    private StringItem status;
    //</editor-fold>//GEN-END:|fields|0|


    public KMM() {
        t=new Thread(this);
        
        th=new Thread(new Runnable(){

            public void run() {
                try{
                    sc=(SocketConnection) Connector.open("socket://nmelo.net:8096");

                    is=sc.openInputStream();
                    os=sc.openOutputStream();
                    
                    t.start();
                    
                }
                catch(Exception e){status.setText(e.getMessage());}
             }
            
        });
        
        th.start();
        
        
        
    }

    //<editor-fold defaultstate="collapsed" desc=" Generated Methods ">//GEN-BEGIN:|methods|0|
    //</editor-fold>//GEN-END:|methods|0|

    //<editor-fold defaultstate="collapsed" desc=" Generated Method: initialize ">//GEN-BEGIN:|0-initialize|0|0-preInitialize
    /**
     * Initilizes the application.
     * It is called only once when the MIDlet is started. The method is called before the <code>startMIDlet</code> method.
     */
    private void initialize() {//GEN-END:|0-initialize|0|0-preInitialize
        
//GEN-LINE:|0-initialize|1|0-postInitialize
        // write post-initialize user code here
    }//GEN-BEGIN:|0-initialize|2|
    //</editor-fold>//GEN-END:|0-initialize|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Method: startMIDlet ">//GEN-BEGIN:|3-startMIDlet|0|3-preAction
    /**
     * Performs an action assigned to the Mobile Device - MIDlet Started point.
     */
    public void startMIDlet() {//GEN-END:|3-startMIDlet|0|3-preAction
        // write pre-action user code here
        switchDisplayable(null, getForm());//GEN-LINE:|3-startMIDlet|1|3-postAction
        s1.setText("");
    }//GEN-BEGIN:|3-startMIDlet|2|
    //</editor-fold>//GEN-END:|3-startMIDlet|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Method: resumeMIDlet ">//GEN-BEGIN:|4-resumeMIDlet|0|4-preAction
    /**
     * Performs an action assigned to the Mobile Device - MIDlet Resumed point.
     */
    public void resumeMIDlet() {//GEN-END:|4-resumeMIDlet|0|4-preAction
        // write pre-action user code here
//GEN-LINE:|4-resumeMIDlet|1|4-postAction
        // write post-action user code here
    }//GEN-BEGIN:|4-resumeMIDlet|2|
    //</editor-fold>//GEN-END:|4-resumeMIDlet|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Method: switchDisplayable ">//GEN-BEGIN:|5-switchDisplayable|0|5-preSwitch
    /**
     * Switches a current displayable in a display. The <code>display</code> instance is taken from <code>getDisplay</code> method. This method is used by all actions in the design for switching displayable.
     * @param alert the Alert which is temporarily set to the display; if <code>null</code>, then <code>nextDisplayable</code> is set immediately
     * @param nextDisplayable the Displayable to be set
     */
    public void switchDisplayable(Alert alert, Displayable nextDisplayable) {//GEN-END:|5-switchDisplayable|0|5-preSwitch
        // write pre-switch user code here
        Display display = getDisplay();//GEN-BEGIN:|5-switchDisplayable|1|5-postSwitch
        if (alert == null) {
            display.setCurrent(nextDisplayable);
        } else {
            display.setCurrent(alert, nextDisplayable);
        }//GEN-END:|5-switchDisplayable|1|5-postSwitch
        // write post-switch user code here
    }//GEN-BEGIN:|5-switchDisplayable|2|
    //</editor-fold>//GEN-END:|5-switchDisplayable|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Method: commandAction for Displayables ">//GEN-BEGIN:|7-commandAction|0|7-preCommandAction
    /**
     * Called by a system to indicated that a command has been invoked on a particular displayable.
     * @param command the Command that was invoked
     * @param displayable the Displayable where the command was invoked
     */
    public void commandAction(Command command, Displayable displayable) {//GEN-END:|7-commandAction|0|7-preCommandAction
        // write pre-action user code here
        if (displayable == form) {//GEN-BEGIN:|7-commandAction|1|19-preAction
            if (command == exitCommand) {//GEN-END:|7-commandAction|1|19-preAction
                
                exitMIDlet();//GEN-LINE:|7-commandAction|2|19-postAction
                // write post-action user code here
            } else if (command == okCommand) {//GEN-LINE:|7-commandAction|3|22-preAction
                send_message();
//GEN-LINE:|7-commandAction|4|22-postAction
                // write post-action user code here
            }//GEN-BEGIN:|7-commandAction|5|7-postCommandAction
        }//GEN-END:|7-commandAction|5|7-postCommandAction
        // write post-action user code here
    }//GEN-BEGIN:|7-commandAction|6|
    //</editor-fold>//GEN-END:|7-commandAction|6|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: exitCommand ">//GEN-BEGIN:|18-getter|0|18-preInit
    /**
     * Returns an initiliazed instance of exitCommand component.
     * @return the initialized component instance
     */
    public Command getExitCommand() {
        if (exitCommand == null) {//GEN-END:|18-getter|0|18-preInit
            // write pre-init user code here
            exitCommand = new Command("Exit", Command.EXIT, 0);//GEN-LINE:|18-getter|1|18-postInit
            // write post-init user code here
        }//GEN-BEGIN:|18-getter|2|
        return exitCommand;
    }
    //</editor-fold>//GEN-END:|18-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: form ">//GEN-BEGIN:|14-getter|0|14-preInit
    /**
     * Returns an initiliazed instance of form component.
     * @return the initialized component instance
     */
    public Form getForm() {
        if (form == null) {//GEN-END:|14-getter|0|14-preInit
            // write pre-init user code here
            form = new Form("KM Messenger", new Item[] { getT1(), getStatus(), getS1() });//GEN-BEGIN:|14-getter|1|14-postInit
            form.addCommand(getExitCommand());
            form.addCommand(getOkCommand());
            form.setCommandListener(this);//GEN-END:|14-getter|1|14-postInit
            form.setItemStateListener(this);
        }//GEN-BEGIN:|14-getter|2|
        return form;
    }
    //</editor-fold>//GEN-END:|14-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: okCommand ">//GEN-BEGIN:|21-getter|0|21-preInit
    /**
     * Returns an initiliazed instance of okCommand component.
     * @return the initialized component instance
     */
    public Command getOkCommand() {
        if (okCommand == null) {//GEN-END:|21-getter|0|21-preInit
            // write pre-init user code here
            okCommand = new Command("Send", Command.OK, 0);//GEN-LINE:|21-getter|1|21-postInit
            // write post-init user code here
        }//GEN-BEGIN:|21-getter|2|
        return okCommand;
    }
    //</editor-fold>//GEN-END:|21-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: t1 ">//GEN-BEGIN:|23-getter|0|23-preInit
    /**
     * Returns an initiliazed instance of t1 component.
     * @return the initialized component instance
     */
    public TextField getT1() {
        if (t1 == null) {//GEN-END:|23-getter|0|23-preInit
            // write pre-init user code here
            t1 = new TextField("Enter text :", null, 128, TextField.ANY);//GEN-LINE:|23-getter|1|23-postInit
            // write post-init user code here
        }//GEN-BEGIN:|23-getter|2|
        return t1;
    }
    //</editor-fold>//GEN-END:|23-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: status ">//GEN-BEGIN:|24-getter|0|24-preInit
    /**
     * Returns an initiliazed instance of status component.
     * @return the initialized component instance
     */
    public StringItem getStatus() {
        if (status == null) {//GEN-END:|24-getter|0|24-preInit
            // write pre-init user code here
            status = new StringItem("", null);//GEN-LINE:|24-getter|1|24-postInit
            // write post-init user code here
        }//GEN-BEGIN:|24-getter|2|
        return status;
    }
    //</editor-fold>//GEN-END:|24-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: s1 ">//GEN-BEGIN:|25-getter|0|25-preInit
    /**
     * Returns an initiliazed instance of s1 component.
     * @return the initialized component instance
     */
    public StringItem getS1() {
        if (s1 == null) {//GEN-END:|25-getter|0|25-preInit
            // write pre-init user code here
            s1 = new StringItem(" ", null);//GEN-LINE:|25-getter|1|25-postInit
            // write post-init user code here
        }//GEN-BEGIN:|25-getter|2|
        return s1;
    }
    //</editor-fold>//GEN-END:|25-getter|2|
    

    public Display getDisplay () {
        return Display.getDisplay(this);
    }


    public void exitMIDlet() {
        close_con();
        switchDisplayable (null, null);
        destroyApp(true);
        notifyDestroyed();
    }


    public void startApp() {
        if (midletPaused) {
            resumeMIDlet ();
        } else {
            initialize ();
            startMIDlet ();
        }
        midletPaused = false;
    }

 
    public void pauseApp() {
        midletPaused = true;
    }

 
    public void destroyApp(boolean unconditional) {
        close_con();
    }

   
    public void send_message()
    {
        try{
            String txt=t1.getString().trim();

            if(!txt.equals("")){
                send(txt);
                String oldtxt=s1.getText();
                oldtxt="Me : "+txt+'\n'+oldtxt;
                if(oldtxt.length()>256) oldtxt=oldtxt.substring(0, 256);
                s1.setText(oldtxt);
                t1.setString("");
                typed=0;
            }
           
        }
        catch(Exception e){status.setText(e.getMessage());}
    }
    
    public void run() {
        
            int c,tilde;
            tilde=(int)'~';
            StringBuffer sb=new StringBuffer();
            
            try{
                Thread.sleep(1000);
                status.setText("Connected");
                while(true){
                    sb=new StringBuffer();
                    while((c=is.read())!=tilde)
                        sb.append((char)c);

                    if(sb.charAt(0)!='`' && sb.charAt(4)!='`')
                    {
                        s1.setText(sb.toString()+'\n'+s1.getText());
                        Display.getDisplay(this).vibrate(200);
                        status.setText(sb.toString());
                    }
                    else
                    {
                        set_status(sb);
                    }
                }
            }
            catch(Exception e){status.setText(e.getMessage());}
   
    }
   
    private void send(final String str) {
        Thread thr=new Thread(new Runnable(){

            public void run() {
                try{
                    os.write(str.getBytes());
                }
                catch(Exception e){status.setText(e.getMessage());}
            }
            
        });
        thr.start();
    }
    
    private void set_status(StringBuffer sb)
    {
        char cmd,cmd2;
        if(sb.toString().length()>3)
        {
            cmd=sb.charAt(5);
        }
        else{
            cmd=sb.charAt(1);
        }
        if(cmd=='t'){
            status.setText("typing...");
        }
        else if(cmd=='n'){
            status.setText("");
        }
        else{
            cmd2=sb.charAt(2);
            if(cmd=='c'){
                status.setText( cmd2+" connected\n"+status.getText());
                Display.getDisplay(this).vibrate(200);
            }
            else if(cmd=='d'){
                status.setText(cmd2+" disconnected"+"\n"+status.getText());
                Display.getDisplay(this).vibrate(200);
            }
            else if(cmd=='o'){
                status.setText(cmd2+" is online"+"\n"+status.getText());

            }
        }
    }
    
    private void close_con(){
        try{
            os.close();
            is.close();
            sc.close();
        }
        catch(Exception e){status.setText(e.getMessage());}
    }

    public void itemStateChanged(Item item) {
        if(item.equals(getT1()))
        {
            try{
            if(typed==0)
            {
                send("`t");
                typed=1;
            }
            else if(typed==1 && t1.getString().equals("")){
                send("`n");
                typed=0;
            }
            }catch(Exception e){status.setText(e.getMessage());}
        }
    }
}
