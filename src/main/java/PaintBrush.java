import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

public class PaintBrush extends JFrame {
    private PaintCanvas canvas;
    private PositionDTO positionDTO;
    private JComboBox<String> colors;

    private int nowStartX, nowStartY, nowEndX, nowEndY;

    private ArrayList<PositionDTO> positionDTOs = new ArrayList<>();
    private ArrayList<Integer> nowPositionsX = new ArrayList<>();
    private ArrayList<Integer> nowPositionsY = new ArrayList<>();

    public PaintBrush() {
        createContainer(createToolBar());
        basicSetting();

        canvas.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                nowStartX = e.getX();
                nowStartY = e.getY();

                nowPositionsX.removeAll(nowPositionsX);
                nowPositionsY.removeAll(nowPositionsY);

                positionDTO = new PositionDTO();
                positionDTO.setStartX(e.getX());
                positionDTO.setStartY(e.getY());
                positionDTO.setColors(colors.getSelectedIndex());
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                positionDTO.setEndX(e.getX());
                positionDTO.setEndY(e.getY());
                positionDTOs.add(positionDTO);
            }
        });

        canvas.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                nowEndX = e.getX();
                nowEndY = e.getY();

                nowPositionsX.add(e.getX());
                nowPositionsY.add(e.getY());

                canvas.repaint();
            }
        });

    }

    private void createContainer(JPanel toolBar) {
        canvas = new PaintCanvas(this, positionDTOs);
        Container c = this.getContentPane();
        c.add("North", toolBar);
        c.add("Center", canvas);
    }

    private JPanel createToolBar() {
        //JRadioButton 생성
        JRadioButton line = new JRadioButton("선");
        JRadioButton circle = new JRadioButton("원");
        JRadioButton rect = new JRadioButton("사각형", true);
        JRadioButton pen = new JRadioButton("연필");
        JRadioButton eraser = new JRadioButton("지우개");

        ButtonGroup group = new ButtonGroup();
        group.add(line);
        group.add(circle);
        group.add(rect);
        group.add(pen);
        group.add(eraser);

        String[] color = {"빨강", "초록", "파랑", "노랑", "보라"};
        colors = new JComboBox<>(color);

        JPanel toolBar = new JPanel();
        toolBar.add(line);
        toolBar.add(circle);
        toolBar.add(rect);
        toolBar.add(pen);
        toolBar.add(eraser);
        toolBar.add(colors);
        return toolBar;
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

    public ArrayList<Integer> getNowPositionsX() {
        return nowPositionsX;
    }

    public ArrayList<Integer> getNowPositionsY() {
        return nowPositionsY;
    }

    public int getNowStartX() {
        return nowStartX;
    }

    public int getNowStartY() {
        return nowStartY;
    }

    public int getNowEndX() {
        return nowEndX;
    }

    public int getNowEndY() {
        return nowEndY;
    }
}
