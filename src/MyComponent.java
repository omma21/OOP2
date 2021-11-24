import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.*;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;


public class MyComponent extends JPanel implements ActionListener {

    private JCheckBox name = new JCheckBox("Name");
    private JCheckBox path = new JCheckBox("Path");
    private JCheckBox size = new JCheckBox("Size");
    private JCheckBox date = new JCheckBox("Date");
    private JCheckBox dimensions = new JCheckBox("Dimensions");
    private JButton button= new JButton("Open");


    private JFrame frame = new JFrame();
    private JPanel panel = new JPanel();

    private File selectedFile=null;
    private String name1 =null;
    private String path1 =null;
    private boolean size1 =false;
    private boolean date1 =false;
    private boolean dimensions1 =false;
    private Component a;


    public MyComponent() {
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setTitle("This is the title");
        frame.setResizable(false);

        panel.add(name);
        name.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (name.isSelected()){
                        name1=selectedFile.getName();
                        panel.remove(a);
                        CustomComponent component = new CustomComponent(selectedFile, name1,path1,size1,date1,dimensions1);
                        a=component;
                }
                if(name.isSelected()==false){

                    name1=null;
                    panel.remove(a);
                    CustomComponent component = new CustomComponent(selectedFile, name1,path1,size1,date1,dimensions1);
                    a=component;
                }

                panel.add(a);
                frame.add(panel);
                frame.pack();
                frame.setVisible(true);
            }
        });
        panel.add(path);
        path.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(path.isSelected()){
                    path1= String.valueOf(selectedFile);
                    panel.remove(a);
                    CustomComponent component = new CustomComponent(selectedFile,name1,path1,size1,date1,dimensions1);
                    a=component;
                    panel.add(a);
                    frame.add(panel);
                    frame.pack();
                    frame.setVisible(true);

                }
            if(path.isSelected()==false){

                path1=null;
                panel.remove(a);
                CustomComponent component = new CustomComponent(selectedFile,name1,path1,size1,date1,dimensions1);
                a=component;
                panel.add(a);
                frame.add(panel);
                frame.pack();
                frame.setVisible(true);

            }
            }
        });
        panel.add(size);
        size.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(size.isSelected()){
                    size1=true;
                    panel.remove(a);
                    CustomComponent component = new CustomComponent(selectedFile, name1,path1, size1,date1,dimensions1);
                    a=component;
                    panel.add(a);
                    frame.add(panel);
                    frame.pack();
                    frame.setVisible(true);

                }
                if(size.isSelected()==false){

                    size1=false;
                    panel.remove(a);
                    CustomComponent component = new CustomComponent(selectedFile,name1,path1,size1,date1,dimensions1);
                    a=component;
                    panel.add(a);
                    frame.add(panel);
                    frame.pack();
                    frame.setVisible(true);

                }

            }
        });
        panel.add(date);
        date.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(date.isSelected()){
                    date1=true;
                    panel.remove(a);
                    CustomComponent component = new CustomComponent(selectedFile, name1, path1, size1, date1,dimensions1);
                    a=component;
                    panel.add(a);
                    frame.add(panel);
                    frame.pack();
                    frame.setVisible(true);

                }
                if(date.isSelected()==false){

                    date1=false;
                    panel.remove(a);
                    CustomComponent component = new CustomComponent(selectedFile, name1, path1, size1, date1,dimensions1);
                    a=component;
                    panel.add(a);
                    frame.add(panel);
                    frame.pack();
                    frame.setVisible(true);

                }
            }
        });
        panel.add(dimensions);
        dimensions.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(dimensions.isSelected()){
                    dimensions1=true;
                    panel.remove(a);
                    CustomComponent component = new CustomComponent(selectedFile, name1,path1,size1,date1,dimensions1);
                    a=component;
                    panel.add(a);
                    frame.add(panel);
                    frame.pack();
                    frame.setVisible(true);

                }
                if(dimensions.isSelected()==false){

                    dimensions1=false;
                    panel.remove(a);
                    CustomComponent component = new CustomComponent(selectedFile, name1, path1, size1, date1,dimensions1);
                    a=component;
                    panel.add(a);
                    frame.add(panel);
                    frame.pack();
                    frame.setVisible(true);

                }

            }
        });

        panel.add(button);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JFileChooser path = new JFileChooser();
                path.setCurrentDirectory(new File(System.getProperty("user.home")));
                //filter the files
                FileNameExtensionFilter filter = new FileNameExtensionFilter("*.Images", "jpg", "gif", "png");

                path.addChoosableFileFilter(filter);
                int result = path.showOpenDialog(null);
                //if the user click on save in Jfilechooser
                if (result == JFileChooser.APPROVE_OPTION) {
                    selectedFile = path.getSelectedFile();
                    String pathf = selectedFile.getAbsolutePath();
                    CustomComponent component = new CustomComponent(selectedFile,name1,path1,size1,date1,dimensions1);
                    a=component;
                    panel.add(a);
                    frame.add(panel);
                    frame.pack();
                    frame.setVisible(true);
                } else if (result == JFileChooser.CANCEL_OPTION) {

                }
                if(result==JFileChooser.CANCEL_OPTION){
                    JOptionPane.showMessageDialog(null,"You have to load an image");
                }


            }
        });


        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
    }

    //
    public static void launch() {

        new MyComponent();
    }

    public static void main(String[] args) {


        SwingUtilities.invokeLater(() -> launch());
    }

   @Override
        public void actionPerformed(ActionEvent e) {

    }
}