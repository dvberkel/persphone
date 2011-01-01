class Paragraph {
	Str text := "You enter an empty room" 
	{
		private set {&text = it}
		get {return &text}
	}
	Option[] options := [,]
	
	new make(Str text) {
		this.text = text
	}
	
	Void addOption(Option option) {
		this.options.add(option)
	}
}
