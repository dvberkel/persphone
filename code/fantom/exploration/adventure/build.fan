class Build : build::BuildPod {
	new make() {
		podName = "adventure"
		summary = "a means to manage create-your-own-adventure stories."
		depends = ["sys 1.0"]
		srcDirs = [`fan/`]		
	}
}
