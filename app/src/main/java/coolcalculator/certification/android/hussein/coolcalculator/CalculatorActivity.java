package coolcalculator.certification.android.hussein.coolcalculator;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class CalculatorActivity extends Activity implements View.OnClickListener{
    TextView resultsView;

    public enum Operation{
        ADD, SUBTRACT, DIVIDE, MULTIPLY, EQUAL
    }
    String runningNumber = "";
    String leftValueStr = "";
    String rightValueStr = "";
    Operation currentOperation;
    int result = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        resultsView = (TextView) findViewById(R.id.resultsText);
        clearTheResultView();


        //keypad digits
        Button oneBtn = (Button) findViewById(R.id.oneBtn);
        Button twoBtn = (Button) findViewById(R.id.twoBtn);
        Button threeBtn = (Button) findViewById(R.id.threeBtn);
        Button fourBtn = (Button) findViewById(R.id.fourBtn);
        Button fiveBtn = (Button) findViewById(R.id.fiveBtn);
        Button sixBtn = (Button) findViewById(R.id.sixBtn);
        Button sevenBtn = (Button) findViewById(R.id.sevenBtn);
        Button eightBtn = (Button) findViewById(R.id.eightBtn);
        Button nineBtn = (Button) findViewById(R.id.nineBtn);
        Button zeroBtn = (Button) findViewById(R.id.zeroBtn);

        //calculation buttons
        ImageButton calcBtn = (ImageButton) findViewById(R.id.calcBtn);
        ImageButton divideBtn = (ImageButton) findViewById(R.id.divideBtn);
        ImageButton multiplyBtn = (ImageButton) findViewById(R.id.multiplyBtn);
        ImageButton subtractBtn = (ImageButton) findViewById(R.id.subtractBtn);
        ImageButton addBtn = (ImageButton) findViewById(R.id.addBtn);

        Button clearButton = (Button) findViewById(R.id.clearBtn);

        // keypad digit listeners
        oneBtn.setOnClickListener(this);
        twoBtn.setOnClickListener(this);
        threeBtn.setOnClickListener(this);
        fourBtn.setOnClickListener(this);
        fiveBtn.setOnClickListener(this);
        sixBtn.setOnClickListener(this);
        sevenBtn.setOnClickListener(this);
        eightBtn.setOnClickListener(this);
        nineBtn.setOnClickListener(this);
        zeroBtn.setOnClickListener(this);

        // arithmetic calculation
        calcBtn.setOnClickListener(this);
        divideBtn.setOnClickListener(this);
        multiplyBtn.setOnClickListener(this);
        addBtn.setOnClickListener(this);
        subtractBtn.setOnClickListener(this);


        clearButton.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.oneBtn:
                numberPressed(1);
                break;
            case R.id.twoBtn:
                numberPressed(2);
                break;
            case R.id.threeBtn:
                numberPressed(3);
                break;
            case R.id.fourBtn:
                numberPressed(4);
                break;
            case R.id.fiveBtn:
                numberPressed(5);
                break;
            case R.id.sixBtn:
                numberPressed(6);
                break;
            case R.id.sevenBtn:
                numberPressed(7);
                break;
            case R.id.eightBtn:
                numberPressed(8);
                break;
            case R.id.nineBtn:
                numberPressed(9);
                break;
            case R.id.zeroBtn:
                numberPressed(0);
                break;
            case R.id.addBtn:
                processOperation(Operation.ADD);
                break;
            case R.id.divideBtn:
                processOperation(Operation.DIVIDE);
                break;
            case R.id.multiplyBtn:
                processOperation(Operation.MULTIPLY);
                break;
            case R.id.subtractBtn:
                processOperation(Operation.SUBTRACT);
                break;
            case R.id.calcBtn:
                processOperation(Operation.EQUAL);
                break;
            case R.id.clearBtn:
                clearTheResultView();
                break;

        }
    }
    private void numberPressed(int num){
        runningNumber += String.valueOf(num);
        resultsView.setText(runningNumber);
    }

    private void clearTheResultView() {
        leftValueStr = "";
        rightValueStr = "";
        result = 0;
        runningNumber = "";
        currentOperation = null;
        resultsView.setText("");
    }
    private void processOperation(Operation operation) {
        if(currentOperation != null){
            if(!runningNumber.isEmpty()){
                rightValueStr = runningNumber;
                runningNumber = "";

                switch (currentOperation){
                    case ADD:
                        result = Integer.parseInt(leftValueStr) + Integer.parseInt(rightValueStr);
                        break;
                    case SUBTRACT:
                        result = Integer.parseInt(leftValueStr) - Integer.parseInt(rightValueStr);
                        break;
                    case MULTIPLY:
                        result = Integer.parseInt(leftValueStr) * Integer.parseInt(rightValueStr);
                        break;
                    case DIVIDE:
                        result = Integer.parseInt(leftValueStr) / Integer.parseInt(rightValueStr);
                        break;
                }
                leftValueStr = String.valueOf(result);
                resultsView.setText(leftValueStr);
            }
        }
        else{
            leftValueStr = runningNumber;
            runningNumber = "";
        }
        currentOperation = operation;

    }

}
