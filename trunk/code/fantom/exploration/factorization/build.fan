class Build : build::BuildPod {
	new make() {
		podName = "Factorization"
		summary = "This pod provides different means to factorize numbers."
		depends = ["sys 1.0"]
		srcDirs = [`fan/`, `test/`]		
	}
}
