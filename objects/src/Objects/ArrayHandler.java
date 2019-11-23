package Objects;

import lombok.AllArgsConstructor;
import lombok.ToString;

@ToString
@AllArgsConstructor
public class ArrayHandler {
    public int[] myArray = new int[10];
    public ArrayHandler() {
        for (int i = 0; i < myArray.length; i++) {
            myArray[i] = (int) (Math.random() * 10);
        }
    }
    public boolean isBalanced(int index) {
        int sumBeforeIndex = 0;
        int sumAfterIndex = 0;
        for (int i = 0; i < index; i++) {
            sumBeforeIndex += myArray[i];
        }
        for (int i = index; i < myArray.length ; i++) {
            sumAfterIndex += myArray[i];
        }
        return sumBeforeIndex == sumAfterIndex;
    }

    public int[] getDuplicates(){
        boolean[] duplicatesCheckArray = new boolean[myArray.length];
        int duplicatesCount = 0;
        for (int i = 0; i < myArray.length; i++) {
            for (int j = 0; j < myArray.length; j++) {
                if (i!=j && myArray[i] == myArray[j]){
                    duplicatesCheckArray[i] = true;
                    duplicatesCount ++;
                    break;
                }
            }
        }
        int[] duplicatesArray = new int[duplicatesCount];
        int duplicatesArrayIndex = 0;
        for (int i = 0; i < duplicatesCheckArray.length; i++) {
            if (duplicatesCheckArray[i]){
               duplicatesArray[duplicatesArrayIndex] = myArray[i];
               duplicatesArrayIndex ++;
            }
        }
        return duplicatesArray;
    }

    public int howManyIn(int[] compareArray) {
        int howManyIn = 0;
        for (int item : compareArray) {
            for (int value : myArray) {
                if (item == value) {
                    howManyIn++;
                }
            }
        }
        return howManyIn;
    }
}
