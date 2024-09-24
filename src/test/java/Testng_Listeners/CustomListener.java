package Testng_Listeners;

import org.testng.IExecutionListener;
import org.testng.ISuiteListener;

public class CustomListener implements IExecutionListener, ISuiteListener {
    @Override
    public void onExecutionStart() {
        System.out.println("On Execution Start");
        long startTime = System.currentTimeMillis();
        System.out.println("** Execution Started AT  --"+startTime);
    }

    @Override
    public void onExecutionFinish() {
        System.out.println("On Execution Stop");
        long endTime = System.currentTimeMillis();
        System.out.println("** Execution Finished AT  --"+endTime);

    }
}
