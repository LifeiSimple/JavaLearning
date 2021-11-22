package v1ch03;

import javax.swing.plaf.synth.SynthEditorPaneUI;

public class Control {
    public static void main(String[] args) {

        int i;
        flag_data:
        for (i=0;i<10;i++)
        {
            for (int j=0;j<i;j++)
            {
//                if (i<5) continue flag_data;
                System.out.print(j);
//                System.out.println();
            }
            System.out.println();
        }
        System.out.println(2333);

    }
}
