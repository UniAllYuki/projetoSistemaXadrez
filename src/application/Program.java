package application;

import java.util.Scanner;

import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		ChessMatch cm = new ChessMatch();
		
		while (true) {
			UI.printBoard(cm.getPieces());
			System.out.println();
			System.out.print("Posicao incial: ");
			ChessPosition source = UI.readChessPosition(sc);
			
			System.out.println();
			System.out.print("Posicao de Destino: ");
			ChessPosition target = UI.readChessPosition(sc);
			
			ChessPiece capturedPiece = cm.performChessMove(source, target);
		}
		
		
	}

}
