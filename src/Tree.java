// Parallel Sum
// 17 September 2018
// Yaseen Hull

import java.util.ArrayList;
import java.util.List;

public class Tree {
	int xT; //x,y terrain
	int yT;
	int x; //x, y co-ordinate of tree origin
	int y;
	int ext; //extent of tree
	float area;
	int xl;// x,y last coordinates
	int yl;
	int [] index;
	int size;//Array list size
	List<Integer> pos = new ArrayList<Integer>(); //list of tree indices

	Tree(int xt, int yt, int x, int y, int e){
		this.xT = xt;
		this.yT = yt;
		this.x = x;
		this.y = y;
		this.ext = e;

		calIndex();
	}

	protected void calIndex() { //calculates indices to be found in terrain data array


		int value;

		for(int i =0; i<ext;i++) {

			for(int j =0; j <ext;j++) {

				value = (x+i)*xT+(y+j);

				if((x+i)>(xT-1) | (y+j)>(yT-1)) { // omits any coordinates beyond the terrains extent
					continue;
				}
				else {
					pos.add(value); // add indices to arraylist
				}


			}

		}

		size = pos.size();
	}

	public void setArea(float sum) {
		this.area = sum;
	}

	public float getArea() {
		return area;
	}

	public int getExtent() {
		return ext*ext;
	}

	protected void setLast() {
		this.xl = x+ext-1;
		this.yl = y+ext-1;

	}

	public int getLastX() {
		return xl;
	}

	public int getLastY() {
		return yl;
	}

	public int getIndex(int i) {
		return index[i];
	}

	public int getElement(int i) {
		return pos.indexOf(i);
	}

	public int getListSize(){
		return size;
	}

}
