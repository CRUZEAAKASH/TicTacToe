package tictactoe;

public class TicTacToe {
	public char[] board;
	public char aiMarker;
	public char PlayerMarker;
	public char currentMarker;
	public char Winner;
	public String PlayerName;
	public String aiName;

	public TicTacToe(char PlayerToken, char aiToken, String playerName) {
		// TODO Auto-generated constructor stub
		this.board = setBoard();
		this.aiMarker = aiToken;
		this.PlayerMarker = PlayerToken;
		this.currentMarker = PlayerMarker;
		this.Winner = '-';
		this.PlayerName = playerName;
		aiName = "COMPUTER";
	}

	public char[] setBoard() {
		char[] board = new char[9];
		for (int i = 0; i < board.length; i++) {
			board[i] = '-';
		}
		return board;
	}

	public void printBoard() {
		for (int i = 0; i < 9; i++) {
			if (i % 3 == 0 && i != 0) {
				System.out.println();
				System.out.println("------------");
			}
			System.out.print(" | " + board[i]);
		}
		System.out.println();
	}

	public void printIndexBoard() {
		for (int i = 0; i < 9; i++) {
			if (i % 3 == 0 && i != 0) {
				System.out.println();
				System.out.println("------------");
			}
			System.out.print(" | " + (i + 1));
		}
		System.out.println();
	}

	public boolean playerTurn(int spot) {
		boolean isValid = isWithinRange(spot) && !(spotTaken(spot));
		if (isValid) {
			board[spot - 1] = currentMarker;
			currentMarker = (currentMarker == PlayerMarker) ? aiMarker : PlayerMarker;

		}
		return isValid;
	}

	public boolean isWithinRange(int number) {
		return number > 0 && number <= 9;
	}

	public boolean spotTaken(int number) {
		return (!(board[number - 1] == '-'));
	}

	public boolean isThereAWinner() {
		boolean diagonalsAndMidrowAndMidColumn = (leftDiag() || rightDiag() || middleRow() || secondCol())
				&& board[4] != '-';
		boolean topRowAndFirstCol = (topRow() || firstCol()) && board[0] != '-';
		boolean lastRowandLastCol = (lastRow() || lastCol()) && board[8] != '-';
		if (diagonalsAndMidrowAndMidColumn)
			Winner = board[4];
		else if (topRowAndFirstCol)
			Winner = board[0];
		else if (lastRowandLastCol)
			Winner = board[8];
		return diagonalsAndMidrowAndMidColumn || topRowAndFirstCol || lastRowandLastCol;
	}

	public boolean rightDiag() {
		return board[0] == board[4] && board[4] == board[8];
	}

	public boolean leftDiag() {
		return board[2] == board[4] && board[4] == board[6];
	}

	public boolean middleRow() {
		return board[3] == board[4] && board[4] == board[5];
	}

	public boolean secondCol() {
		return board[1] == board[4] && board[4] == board[7];
	}

	public boolean topRow() {
		return board[0] == board[1] && board[1] == board[2];
	}

	public boolean firstCol() {
		return board[0] == board[3] && board[3] == board[6];
	}

	public boolean lastRow() {
		return board[6] == board[7] && board[7] == board[8];
	}

	public boolean lastCol() {
		return board[2] == board[5] && board[5] == board[8];
	}

	public boolean isGameOver() {
		boolean didSomeoneWin = isThereAWinner();
		String WinnerName = getWinnerName();
		if (didSomeoneWin) {
			System.out.println("We have a winner!!!!!!!!!!!");
			System.out.println("And the Winner is " + WinnerName);
		} else if (isBoardFilled()) {
			System.out.println("GAME OVER!!!!!!!!!");
		} else {
			System.out.println("Not Over");
		}
		return didSomeoneWin;
	}

	public String getWinnerName() {
		// TODO Auto-generated method stub
		if (Winner == PlayerMarker)
			return PlayerName;
		else
			return aiName;
	}

	public boolean isBoardFilled() {
		for (int i = 0; i < board.length; i++) {
			if (board[i] == '-') {
				return false;
			}
		}
		return true;
	}
}
