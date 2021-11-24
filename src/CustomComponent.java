import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Date;

public class CustomComponent extends JComponent {
    private BufferedImage image;

    private String name1=null;
    private String path1=null;
    private String size1 =null;
    private String date1 =null;
    private String dimensions1=null;


    public CustomComponent(File selectedFile, String name, String path, boolean size, boolean date, boolean dimensions) {
        try {
//
            this.image = ImageIO.read(selectedFile);

            int w= this.image.getWidth();
            int h= this.image.getHeight();

            name1=name;
            path1=path;
            if (size){
                long bytes= Files.size(java.nio.file.Path.of(String.valueOf(selectedFile)));
                size1= String.valueOf(bytes);
            }
            if(date){
                File file = new File(String.valueOf(selectedFile));
                long timepstamp =file.lastModified();
                date1= String.valueOf(new Date(timepstamp));
            }
            if(dimensions){
                String width = Integer.toString(w);
                String height = Integer.toString(h);
                dimensions1 = width + "X"+ height;
            }

            setPreferredSize(new Dimension(w,h));

        } catch (IOException x) {
            JOptionPane.showMessageDialog(null,"image cannot be load");

        }
    }

    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        g = g.create();
        g.setColor(Color.RED);
        g.fillRect(0, 0, getWidth(), getHeight());


        int margin = 1;
        g.drawImage(this.image,margin,margin,this.image.getWidth(),this.image.getHeight(),this);
        g.setFont(getFont().deriveFont(20f));

        int i=0;


        if(name1!=null){
            g.drawString(name1,50,50);
            i=i+40;
        }
        if(path1 !=null){
            g.drawString(path1,50,50+i);
            i=i+40;
    }
        if(size1 !=null){
            g.drawString(size1,50,50+i);
            i=i+40;
        }
        if(date1 !=null){
            g.drawString(date1,50,50+i);
            i=i+40;
        }
        if(dimensions1 !=null){
            g.drawString(dimensions1,50,50+i);
            i=i+40;
        }
    }
}
