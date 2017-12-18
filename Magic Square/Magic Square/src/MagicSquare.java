import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MagicSquare {
	
	//TODO: always use .length or make new array
	private int[][] square;
	
	public MagicSquare() {
		
	}
	
	public int askUser() throws IOException {
		//input reader
		InputStreamReader reader = new InputStreamReader(System.in);
		BufferedReader input = new BufferedReader(reader);
		
		System.out.println("Please enter the dimension of your magic square as an odd integer.");
		String inputValue = input.readLine();
		while (!isOddInt(inputValue)) {
			System.out.println("Please enter a valid dimension.");
			inputValue = input.readLine();
		}
		
		return new Integer(inputValue);
	}
	
	public void setSquareDim(int dim) {
		square = new int[dim][dim];
	}
	
	//method to check if a string is an integer
	public boolean isOddInt(String input) {
		try {
	        int num = new Integer(input);
	        if (num < 3 || num >= 20)
	        	return false;
	        else if (num % 2 == 0)
	        	return false;
	        else
	        	return true;
	    } catch (Exception e) {
	        return false;
	    }
	}
	
	public void buildSquare() {
		int rowIndex = 0;
		int colIndex = square.length / 2;
		int numToAdd = 1;
		
		while (numToAdd <= Math.pow(square.length, 2)) {
			
			square[rowIndex][colIndex] = numToAdd;
			
			rowIndex--;
			colIndex++;
			
			int oriRowIndex = rowIndex;
			int oriColIndex = colIndex;
			
			if (rowIndex < 0) {
				rowIndex = square.length - 1;
			}
			
			if (colIndex >= square.length) {
				colIndex = 0;
			}
			
			if (square[rowIndex][colIndex] != 0) {
				colIndex = oriColIndex - 1;
				rowIndex = oriRowIndex + 2;
			}
			
			numToAdd++;
		}
		
	}
	
	public void printSquare() {
		for (int i = 0; i < square.length; i++) {
			for (int j = 0; j < square.length; j++) {
				System.out.print(square[i][j] + " ");
			}
			System.out.println();
		}
		
	}
	
	public static void main (String args[]) throws IOException {
		MagicSquare square = new MagicSquare();
		
		int dim = square.askUser();
		square.setSquareDim(dim);
		square.buildSquare();
		square.printSquare();
	
	}
}

/*
Please enter the dimension of your magic square as an odd integer.
5
17 24 1 8 15 
23 5 7 14 16 
4 6 13 20 22 
10 12 19 21 3 
11 18 25 2 9 

Please enter the dimension of your magic square as an odd integer.
19
192 213 234 255 276 297 318 339 360 1 22 43 64 85 106 127 148 169 190 
212 233 254 275 296 317 338 359 19 21 42 63 84 105 126 147 168 189 191 
232 253 274 295 316 337 358 18 20 41 62 83 104 125 146 167 188 209 211 
252 273 294 315 336 357 17 38 40 61 82 103 124 145 166 187 208 210 231 
272 293 314 335 356 16 37 39 60 81 102 123 144 165 186 207 228 230 251 
292 313 334 355 15 36 57 59 80 101 122 143 164 185 206 227 229 250 271 
312 333 354 14 35 56 58 79 100 121 142 163 184 205 226 247 249 270 291 
332 353 13 34 55 76 78 99 120 141 162 183 204 225 246 248 269 290 311 
352 12 33 54 75 77 98 119 140 161 182 203 224 245 266 268 289 310 331 
11 32 53 74 95 97 118 139 160 181 202 223 244 265 267 288 309 330 351 
31 52 73 94 96 117 138 159 180 201 222 243 264 285 287 308 329 350 10 
51 72 93 114 116 137 158 179 200 221 242 263 284 286 307 328 349 9 30 
71 92 113 115 136 157 178 199 220 241 262 283 304 306 327 348 8 29 50 
91 112 133 135 156 177 198 219 240 261 282 303 305 326 347 7 28 49 70 
111 132 134 155 176 197 218 239 260 281 302 323 325 346 6 27 48 69 90 
131 152 154 175 196 217 238 259 280 301 322 324 345 5 26 47 68 89 110 
151 153 174 195 216 237 258 279 300 321 342 344 4 25 46 67 88 109 130 
171 173 194 215 236 257 278 299 320 341 343 3 24 45 66 87 108 129 150 
172 193 214 235 256 277 298 319 340 361 2 23 44 65 86 107 128 149 170 

 */
