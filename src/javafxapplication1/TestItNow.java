/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication1;

import com.sun.javafx.functions.Function0;
import javafx.lang.FX;

/**
 *
 * @author cy6ergn0m
 */
public class TestItNow {

    private static class MyAction implements Function0<Void> {

        private final MyIface face;

        public MyAction( MyIface face ) {
            this.face = face;
        }

        @Override
        public Void invoke() {
            face.setValue( face.getValue() + 1 );
            return null;
        }

    }

    public boolean testItNow( MyIface ptr ) {
        final MyAction a = new MyAction( ptr );
        new Thread() {

            @Override
            public void run() {
                try {
                    while( true ) {
                        Thread.sleep( 700 );
                        FX.deferAction( a );
                    }
                } catch( InterruptedException ignore ) {
                }
            }

        }.start();
        return ptr.test();
    }

}
