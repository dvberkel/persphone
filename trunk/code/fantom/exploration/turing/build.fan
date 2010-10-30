class Build : build::BuildPod 
{
	new make()
	{
		podName = "turing"
		summary = "a implementation of a turing machine"
		depends = ["sys 1.0"]
		srcDirs = [`fan/`]
	}
}
