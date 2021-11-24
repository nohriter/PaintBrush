import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class PaintBrush extends Frame {

    public PaintBrush() {
        //JRadioButton 생성
        JRadioButton line = new JRadioButton("선");
        JRadioButton circle = new JRadioButton("원");
        JRadioButton rect = new JRadioButton("사각형", true);
        JRadioButton roundRect = new JRadioButton("둥근사각형");
        JRadioButton pen = new JRadioButton("연필");

        ButtonGroup group = new ButtonGroup();
        group.add(line);
        group.add(circle);
        group.add(rect);
        group.add(roundRect);
        group.add(pen);

        String[] color = {"빨강", "초록", "파랑", "노랑", "보라"};
        JComboBox<String> combo = new JComboBox<>(color);

        JPanel southP = new JPanel();
        southP.add(line);
        southP.add(circle);
        southP.add(rect);
        southP.add(roundRect);
        southP.add(pen);
        southP.add(combo);

        add(southP);

        basicSetting();
    }

    private void basicSetting() {
        setSize(1024, 600);
        setTitle("Paint Brush");
        setLocationRelativeTo(null);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        setVisible(true);
    }

}
