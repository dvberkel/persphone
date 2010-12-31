class Paragraph {
	Str text := "You enter an empty room" 
	{
		private set {&text = it}
		get {return &text}
	}
	
	new make(Str text) {
		this.text = text
	}
}
