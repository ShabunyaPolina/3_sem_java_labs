package lab.program;

import lab.entity.Matrix;
import lab.action.Decomposer;
import lab.action.Inverter;

public class Program {
    public static void main(String[] args) {
        Matrix m = new Matrix(3, 3);

        m.setElement(0, 0, 1);
        m.setElement(0, 1, 2);
        m.setElement(0, 2, 3);
        m.setElement(1, 0, 2);
        m.setElement(1, 1, 5);
        m.setElement(1, 2, 4);
        m.setElement(2, 0, 3);
        m.setElement(2, 1, 6);
        m.setElement(2, 2, 10);

        System.out.println(m.toString());

        Decomposer d = new Decomposer();
        System.out.println(d.decomposeOnLU(m).toString());

        Inverter inv = new Inverter();
        inv.invertMatrix(m);
        System.out.println(inv.invertMatrix(m));
    }
}
