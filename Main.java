import java.util.*;

import javax.swing.*;
import javax.swing.Timer;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.*;
import java.awt.*;

import DataStructure.Array;
import DataStructure.Unit;


public class Main{
    private static int DELAY = 500;
    
    private static Timer timer;
    
    private static int switch_mod = 0;           //1 for Array, 2 for binarysearch tree
    private static int op = 0;           //1 for insert
    private static int content = 0;

    static Stack<Unit> temp = new Stack<Unit>();
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable(){
            @Override
            public void run(){
                MyFrame frame= new MyFrame();
                frame.setVisible(true);
            }
        }); 
    }


    public static class MyFrame extends JFrame{
        public static final String TITLE = "Data Structure in Java";
        public static final int WIDTH = 1600;
        public static final int HEIGHT = 900;
        public MyFrame(){
            super();
            init();
        }
        private void init() {
            
            setTitle(TITLE);
            setSize(WIDTH, HEIGHT);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setLocationRelativeTo(null); 
            MyPanel panel = new MyPanel(this);
            setContentPane(panel);
        }
    }


    public static class MyPanel extends JPanel{
        private MyFrame frame;
        private int i = 0;
        public MyPanel(MyFrame frame){
            super();
            this.frame = frame;

            timer = new Timer(DELAY, new ReboundListener());
		    timer.start();
            init();
        }
        private void init() {
            JRadioButton switch_array = new JRadioButton("Array");
            JRadioButton switch_binarystree = new JRadioButton("Array");

            switch_array.addChangeListener(new ChangeListener(){
                @Override
                public void stateChanged(ChangeEvent e){
                    switch_mod = 1;
                }
            });
            switch_binarystree.addChangeListener(new ChangeListener(){
                @Override
                public void stateChanged(ChangeEvent e){
                    switch_mod = 2;
                }
            });

            ButtonGroup switch_ds = new ButtonGroup();
            switch_ds.add(switch_array);

            JPanel box_insert = new JPanel();
            box_insert.add(new JLabel("Insert"));

            final JTextField Text_insert = new JTextField(10);
            box_insert.add(Text_insert);

            JPanel box_confirm = new JPanel();

            final JButton btn_confirm = new JButton("OK");
            btn_confirm.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e){
                    op = 1;
                    
                    content = Integer.valueOf(Text_insert.getText());
                }
            });
            box_confirm.add(btn_confirm);
            Box vBox = Box.createHorizontalBox();

            vBox.add(switch_array);
            vBox.add(box_insert);
            vBox.add(box_confirm);
            add(vBox);
        }



        @Override
        protected void paintComponent(Graphics g){
            super.paintComponent(g);
            switch(switch_mod){
                case 0: break;
                case 1: DrawArray(g);
                //case 2: S_BinartSTree(g);
            }
            this.repaint();
        }

        private class ReboundListener implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                switch(switch_mod){
                    case 0: break;
                    case 1: S_Array();
                    //case 2: S_BinartSTree();
                }
                repaint();
            }
        }


        private void DrawCircle(Graphics g, int _x, int _y, int cur, int val){
            Graphics2D g2d = (Graphics2D)g.create();
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            if(cur==0) g2d.setColor(Color.BLACK);
            else g2d.setColor(Color.RED);
            g2d.drawOval(_x, _y, 2*Unit.R, 2*Unit.R);
            g2d.drawString(String.valueOf(val), _x+Unit.R, _y+Unit.R);
            g2d.dispose();
        }


        private void S_Array(){
            Unit i_unit;
            
            switch(op){
                case 0:
                    break;
                case 1:
                    i_unit = new Unit(content);
                    if(Array.insert(i_unit,i++)!=-1){
                        op = 0;
                        i = 0;
                    }
                    break;                    
            }
        }
        private void DrawArray(Graphics g){
            Unit i_unit;
            int i = 0;
            i_unit = Array.get(i++); 
            while(i_unit!=null){
                DrawCircle(g,i_unit.getX(),i_unit.getY(),i_unit.getC(),i_unit.getV());
                i_unit = Array.get(i++); 
            }
            this.repaint();
        }


        private void S_BinartSTree(Graphics g){

        }
        private void DrawBinarySTree(Graphics g){

        }
    }    
}


