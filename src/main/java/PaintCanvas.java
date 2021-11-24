import java.awt.*;
import java.util.ArrayList;

public class PaintCanvas extends Canvas {
    private PaintBrush paintBrush;
    private ArrayList<PositionDTO> positionDTOs;

    public PaintCanvas(PaintBrush paintBrush, ArrayList<PositionDTO> PositionDTOs) {
        this.paintBrush = paintBrush;
        this.positionDTOs = PositionDTOs;

        setBackground(new Color(239, 255, 239));
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        for(PositionDTO dto : positionDTOs) {
            int startX = dto.getStartX();
            int startY = dto.getStartY();
            int endX = dto.getEndX();
            int endY = dto.getEndY();

            if (startX > endX) {
                int tem = 0;
                tem = startX;
                startX = endX;
                endX = tem;
            }
            if (startY > endY) {
                int tem = 0;
                tem = startY;
                startY = endY;
                endY = tem;
            }

            g.drawRect(startX, startY, endX - startX, endY - startY);
        }

        ArrayList<Integer> nowPositionsX = paintBrush.getNowPositionsX();
        ArrayList<Integer> nowPositionsY = paintBrush.getNowPositionsY();

        int nowStartX = paintBrush.getNowStartX();
        int nowStartY = paintBrush.getNowStartY();
        int nowEndX = paintBrush.getNowEndX();
        int nowEndY = paintBrush.getNowEndY();

        if (nowStartX > nowEndX) {
            int tem = 0;
            tem = nowStartX;
            nowStartX = nowEndX;
            nowEndX = tem;
        }
        if (nowStartY > nowEndY) {
            int tem = 0;
            tem = nowStartY;
            nowStartY = nowEndY;
            nowEndY = tem;
        }

        g.drawRect(nowStartX, nowStartY, nowEndX - nowStartX, nowEndY - nowStartY);
    }
}
