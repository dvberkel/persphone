%-- Identification -------------------------------------------------------------

\ProvidesClass{curriculum-vitea}[2009/05/11 personal curriculum vitea class]
\NeedsTeXFormat{LaTeX2e}[1993/11/11]

%-- Initial Code ---------------------------------------------------------------

\newcommand{\nameName}{Name}
\newcommand{\addressName}{Address}
\newcommand{\cityName}{City}
\newcommand{\telephoneName}{Telephone}
\newcommand{\emailName}{Email}
\newcommand{\birthdayName}{Birthday}
\newcommand{\nationalityName}{Nationality}
\newcommand{\maritalStatusName}{Marital status}

\newcommand{\companyName}{Company}
\newcommand{\functionName}{Function}
\newcommand{\periodName}{Period}
\newcommand{\technicsName}{Used techniques}

\newcommand{\presentName}{present}

\newcommand{\name}{???}
\newcommand{\address}{???}
\newcommand{\city}{???}
\newcommand{\telephone}{???}
\newcommand{\email}{???}
\newcommand{\birthday}{???}
\newcommand{\nationality}{???}
\newcommand{\maritalStatus}{???}

%-- Declaration of Options -----------------------------------------------------

\DeclareOption{dutch}{%
	\PassOptionsToPackage{dutch}{babel}%
	\renewcommand{\nameName}{Naam}%
	\renewcommand{\addressName}{Adres}%			
	\renewcommand{\cityName}{Plaats}%
	\renewcommand{\telephoneName}{Telefoonnummer}%
	\renewcommand{\emailName}{Email}%
	\renewcommand{\birthdayName}{Geboortedatum}%
	\renewcommand{\nationalityName}{Nationaliteit}%
	\renewcommand{\maritalStatusName}{Burgelijke staat}%
	\renewcommand{\companyName}{Bedrijf}%
	\renewcommand{\functionName}{Functie}%
	\renewcommand{\periodName}{Periode}%
	\renewcommand{\technicsName}{Gebruikte technieken / methoden}%
	\renewcommand{\presentName}{heden}%
}

\DeclareOption*{\PassOptionsToClass{\CurrentOption}{book}}

%-- Execution of Options -------------------------------------------------------

\ProcessOptions*

%-- Package Loading ------------------------------------------------------------

\LoadClass{article}

\RequirePackage{calc}
\RequirePackage{ifthen}
\RequirePackage{geometry}
\RequirePackage{fancyhdr}

%-- Main Code ------------------------------------------------------------------

\geometry{
	a4paper,
	marginratio={1:1,2:3},
	scale={.7,.8},
	ignoreall,
	headheight=1cm
}

%>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

\pagestyle{fancy}

\lhead[]{} \lfoot[]{}
\chead[]{} \cfoot[\fancyplain{}{\thepage}]{\fancyplain{}{\thepage}}
\rhead[]{} \rfoot[]{}

%>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

\newcommand{\descriptionListLabel}[1]{\mbox{#1:}\hfill}
\newcommand{\newDescriptionList}[2][5cm]{%
	\newenvironment{#2}{%
		\begin{list}{}{%
			\renewcommand{\makelabel}{\descriptionListLabel}%
			\setlength{\labelwidth}{#1}%
			\setlength{\labelsep}{1em}%
			\setlength{\leftmargin}{\labelwidth+\labelsep}%
			\setlength{\itemsep}{0ex}%
			\setlength{\parsep}{0ex}%
		}%
	}{%
		\end{list}%
	}%
}

%>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

\newDescriptionList{credentialsList}
\newcommand{\credentials}{%
	\begin{credentialsList}%
		\item[\nameName] \name%
		\item[\addressName] \address%
		\item[\cityName] \city%
		\item[\telephoneName] \telephone%
		\item[\emailName] \email%
		\item[\birthdayName] \birthday%
		\item[\nationalityName] \nationality%
		\item[\maritalStatusName] \maritalStatus%
	\end{credentialsList}%
}

\newDescriptionList{educationList}
\newDescriptionList{languageList}
\newDescriptionList{courseList}
\newDescriptionList{subActivityList}
\newDescriptionList{skillList}

%>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

\newcommand{\activity}[1]{\hfill\\\textbf{#1}\hfill\\}
\newcommand{\technics}{\hfill\\\textit{\technicsName}.\hfill\\}
\newDescriptionList{workDescriptionList}
\newenvironment{workExperience}[3]{%
	\noindent\rule{\linewidth}{1pt}
	\begin{workDescriptionList}
		\item[\companyName] #1
		\item[\functionName] #2
		\item[\periodName] #3
	\end{workDescriptionList}
}{}

%>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

\newcommand{\moment}[3][noDay]{% arguments: [day] month year
	\ifthenelse{\equal{#1}{noDay}}{{#2}-{#3}}{{#1}-{#2}-{#3}}%
}
	
\newcommand{\present}{\presentName}
\newcommand{\period}[2]{#1 --- #2}


