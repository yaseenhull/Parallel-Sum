// Parallel Sum
// 17 September 2018
// Yaseen Hull

import java.util.concurrent.RecursiveTask;

public class ParallelSum extends RecursiveTask<Float> {

	 int lo; // arguments
	 int hi;
	 float total = 0;

	 static final int SEQUENTIAL_CUTOFF=500000; //manually adjust for performance enhancement
	 //float ans; // result

	 Tree [] list;
	 float [] data;
	 float [] output;
	 ParallelSum(Tree [] a, int l, int h,float [] in, float [] out) {

		 lo = l;
		 hi = h;
		 list = a;
		 data = in;
		 output = out;

	 }

	@Override
	protected Float compute() {
		// TODO Auto-generated method stub
		if((hi-lo) < SEQUENTIAL_CUTOFF) {

		      for(int i=lo; i < hi; i++) {
			    	float ans = 0;
		    	  	for(int j = 0; j<list[i].pos.size();j++) { // iterates for arraylist of each tree size
		    	  		ans+= data[list[i].pos.get(j)]; //fetches value in arraylist and uses it as index for terrain data array

		    	  	}
		    	  	output[i] = ans;
				total+=ans;

		      }

		      return total;
		}
		 else {
			  ParallelSum left = new ParallelSum(list,lo,(hi+lo)/2,data, output);
			  ParallelSum right= new ParallelSum(list,(hi+lo)/2,hi,data, output);


			  left.fork();
			  float leftAns = right.compute();
			  float rightAns = left.join();
			  float Answer = leftAns + rightAns;

			  return Answer;


		  }
	}


}
