import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class PaintBrush extends Frame {

    public PaintBrush() {

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
