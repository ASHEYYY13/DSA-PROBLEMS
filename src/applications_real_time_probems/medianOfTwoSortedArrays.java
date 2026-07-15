package applications_real_time_probems;

public class medianOfTwoSortedArrays {
    public static void main(String[] args) {
        int[] a={};
        int[] b={2,4,5,6};
        System.out.println(medianBruteForce(a,b));
    }

    private static double medianBruteForce(int[] a, int[] b) {
        int[] arr=new int[a.length+b.length];
        int j=0;
        int k=0;
        int i=0;
        while (j<a.length && k<b.length){
            if(a[j]>b[k]){
                arr[i++]=b[k];
                k++;
            }
            else {
                arr[i++]=a[j];
                j++;
            }
        }
        while (j<a.length){
            arr[i++]=a[j];
            j++;
        }

        while (k<b.length){
            arr[i++]=b[k];
            k++;
        }
        int mid=arr.length/2;
        if(arr.length%2==1){
            return arr[mid];
        }
      return  (double) (arr[mid]+arr[mid - 1])/2;
    }
}
