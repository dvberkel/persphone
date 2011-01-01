class Main {
	public static Void main() {
		Paragraph paragraph := Paragraph.make("You enter a dark and murky room. The left facing wall contains a wooden door.")
		Option left := Option.make("Would like to open the door?")
		Option search := Option.make("Search the room?")
		
		paragraph.addOption(left)
		paragraph.addOption(search)
		echo(paragraph.text)
	}
}
