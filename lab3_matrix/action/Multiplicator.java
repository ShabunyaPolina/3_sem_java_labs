package lab.action;

import lab.entity.Matrix;

public class Multiplicator {
    public Matrix multiply(Matrix p, Matrix q) {
        int v = p.getVerticalSize();
        int h = q.getHorizontalSize();
        int controlSize = p.getHorizontalSize();
        Matrix result = new Matrix(v, h);
        for (int i = 0; i < v; i++) {
            for (int j = 0; j < h; j++) {
                int value = 0;
                for (int k = 0; k < controlSize; k++) {
                    value += p.getElement(i, k) * q.getElement(k, j);
                }
                result.setElement(i, j, value);
            }
        }
        return result;
    }
}
