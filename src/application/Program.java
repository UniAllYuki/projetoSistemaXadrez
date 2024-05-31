package application;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import chess.ChessExpection;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		ChessMatch cm = new ChessMatch();
		
		List<ChessPiece> captured = new ArrayList<>();
		
		while (!cm.getCheckMate()) {
			try {
				UI.clearScreen();
				UI.printMatch(cm, captured);
				System.out.println();
				System.out.print("Posicao incial: ");
				ChessPosition source = UI.readChessPosition(sc);
				
				boolean[][] possibleMoves = cm.possibleMoves(source);
				UI.clearScreen();
				UI.printBoard(cm.getPieces(), possibleMoves);
				
				System.out.println();
				System.out.print("Posicao de Destino: ");
				ChessPosition target = UI.readChessPosition(sc);
				
				ChessPiece capturedPiece = cm.performChessMove(source, target);
				
				if (capturedPiece != null) {
					captured.add(capturedPiece);
				}
				
				if(cm.getPromoted() != null) {
					System.out.println("Diga para qual peca voce quer se promover (B/C/T/Q): ");
					String type = sc.nextLine();
					cm.replacePromotedPiece(type);
				}
				
			}
			catch (ChessExpection e) {
				System.out.println(e.getMessage());
				sc.nextLine();
			}
			catch (InputMismatchException e) {
				System.out.println(e.getMessage());
				sc.nextLine();
			}
		}
		UI.clearScreen();
		UI.printMatch(cm, captured);
		
	}

}
