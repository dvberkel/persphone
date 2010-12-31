class Option {
	Str text := "Did you really think you had any choice?" 
	{
		private set {&text = it}
	}
	Paragraph? paragraph
	
	new make(Str text) {
		this.text = text
	}
}
