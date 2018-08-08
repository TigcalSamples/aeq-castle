package com.tigcal.aeq.castle;

public class CastleBuilder {

	public static void main(String[] args) {
		int[] landHeights = {2,6,6,3};

		int numberOfCastles = getNumberOfCastles(landHeights);
		if(numberOfCastles == 0) {
			System.out.println("You can't build any castles in the stretch of the land.");
		} else {
			System.out.println("You can build " + numberOfCastles + (numberOfCastles == 1 ? " castle" : " castles") + " in the stretch of the land.");
		}
	}

	public static int getNumberOfCastles(int[] landHeights) {
		if (landHeights == null || landHeights.length < 1) {
			return 0;
		}

		int castles = 1;

		int previous;
		int current;
		int next;
		//negative downwards, positive upwards
		int slope = 0;

		for(int i=1; i<landHeights.length-1; i++) {
			previous = landHeights[i-1];
			current = landHeights[i];
			next = landHeights[i+1];

			if(current > previous && current > next) {
				//peak
				castles++;
				slope = -1;
			} else if(current < previous && current < next ) {
				//valley
				castles++;
				slope = 1;
			} else if(current > previous && current >= next) {
				slope = 1;
			} else if(current < previous && current >= next) {
				slope = -1;
			} else if (current > next && slope == 1) {
				//plateau peak
				castles++;
				slope = -1;
			} else if (current < next && slope == -1) {
				//valley
				castles++;
				slope = 1;
			}
		}

		return castles;
	}

}
