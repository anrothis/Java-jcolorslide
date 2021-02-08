import javax.swing.*;
import javax.swing.event.*;
import java.util.Hashtable;
import java.awt.*;

public class colSlide implements ChangeListener {
    
    JFrame frame;
    JPanel panel;
    JLabel rgb;
    JSlider blue, red, green;
    Hashtable<Integer, JLabel> r,g,b;
    Color rgbVal;

    public colSlide()
    {
        
        r = new Hashtable<Integer, JLabel>();
        g = new Hashtable<Integer, JLabel>();
        b = new Hashtable<Integer, JLabel>();
        
        for(int i = 0; i < 256; i++)
        {
            r.put(i, new JLabel(Integer.toString(i)));
            g.put(i, new JLabel(Integer.toString(i)));
            b.put(i, new JLabel(Integer.toString(i)));
        }
        
        red = new JSlider(0,255,125);
        green = new JSlider(0,255,0);
        blue = new JSlider(0,255,125);
        
        frame = new JFrame("Color Slider");
        panel = new JPanel();
        rgb = new JLabel();
        
        red.setLabelTable(r);
        green.setLabelTable(g);
        blue.setLabelTable(b);
        
        red.setPreferredSize(new Dimension(70,300));
        green.setPreferredSize(new Dimension(70,300));
        blue.setPreferredSize(new Dimension(70,300));

        red.setOrientation(SwingConstants.VERTICAL);
        green.setOrientation(SwingConstants.VERTICAL);
        blue.setOrientation(SwingConstants.VERTICAL);
        
        red.setPaintTicks(true);
        green.setPaintTicks(true);
        blue.setPaintTicks(true);

        red.addChangeListener(this);
        green.addChangeListener(this);
        blue.addChangeListener(this);

        rgb.setText("RGB: "+red.getValue() +" "+green.getValue() +" "+blue.getValue());
        
        rgbVal = new Color(red.getValue(),green.getValue(),blue.getValue());

        red.setBackground(rgbVal);
        green.setBackground(rgbVal);
        blue.setBackground(rgbVal);

        rgb.setBackground(rgbVal.brighter().brighter());
        
        panel.setBackground(rgbVal);
        panel.setOpaque(true);
        
        panel.add(red);
        panel.add(green);
        panel.add(blue);
        panel.add(rgb);
        
        frame.add(panel);
        frame.setSize(new Dimension(250,420));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }
    
    public void stateChanged(ChangeEvent event) {
        rgbVal = new Color(red.getValue(),green.getValue(),blue.getValue());
        
        panel.setBackground(rgbVal);
        red.setBackground(rgbVal);
        green.setBackground(rgbVal);
        blue.setBackground(rgbVal);
        rgb.setText("RGB: "+red.getValue() +" "+green.getValue() +" "+blue.getValue());
    }
}