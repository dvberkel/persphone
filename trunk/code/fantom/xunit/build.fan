class Build : build::BuildPod {
	new make() {
		podName = "fan-unit"
		summary = "A unit testing framework for the fantom programming language"
		depends = ["sys 1.0"]
		srcDirs = [`fan/src/`, `fan/test/`]		
	}
}
