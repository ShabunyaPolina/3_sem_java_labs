package lab.action;

import lab.entity.Matrix;
import lab.exception.MatrixException;

public class Decomposer {
    public Matrix decomposeOnLU(Matrix matrix) throws MatrixException {
        if(matrix.getVerticalSize() != matrix.getHorizontalSize())
            throw new MatrixException("Non-square matrix");
        int n = matrix.getVerticalSize();
        Matrix lu = new Matrix(matrix);
        for (int k = 0; k < n - 1; ++k) {
            for (int i = k + 1; i < n; ++i) {
                lu.setElement(i, k, lu.getElement(i, k) / lu.getElement(k, k));
                for (int j = k + 1; j < n; ++j) {
                    lu.setElement(i, j, lu.getElement(i, j) -
                            lu.getElement(i, k) * lu.getElement(k, j));
                }
            }
        }
        return lu;
    }
}
