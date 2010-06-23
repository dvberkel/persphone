%-- Identification -------------------------------------------------------------

\ProvidesClass{thesis}[2006/08/11 personal thesis class]
\NeedsTeXFormat{LaTeX2e}[1993/11/11]

%-- Initial Code ---------------------------------------------------------------

\newcommand{\notationname}{Notation}      \newcommand{\notationend}{\ensuremath{\bowtie}}       \newcommand{\notationstyle}{}
\newcommand{\definitionname}{Definition}  \newcommand{\definitionend}{\ensuremath{\circ}}       \newcommand{\definitionstyle}{}
\newcommand{\remarkname}{Remark}          \newcommand{\remarkend}{\ensuremath{\triangleleft}}   \newcommand{\remarkstyle}{}
\newcommand{\examplename}{Example}        \newcommand{\exampleend}{\ensuremath{\triangleright}} \newcommand{\examplestyle}{}
\newcommand{\conjecturename}{Conjecture}  \newcommand{\conjectureend}{\ensuremath{\diamond}}    \newcommand{\conjecturestyle}{\itshape}
\newcommand{\lemmaname}{Lemma}            \newcommand{\lemmaend}{\ensuremath{\diamond}}         \newcommand{\lemmastyle}{\itshape}
\newcommand{\theoremname}{Theorem}        \newcommand{\theoremend}{\ensuremath{\diamond}}       \newcommand{\theoremstyle}{\itshape}
\newcommand{\propositionname}{Proposition}\newcommand{\propositionend}{\ensuremath{\diamond}}   \newcommand{\propositionstyle}{\itshape}
\newcommand{\corollaryname}{Corollary}    \newcommand{\corollaryend}{\ensuremath{\diamond}}     \newcommand{\corollarystyle}{\itshape}
\newcommand{\proofname}{Proof}            \newcommand{\proofend}{\ensuremath{\square}}          \newcommand{\proofstyle}{}

%-- Declaration of Options -----------------------------------------------------

\DeclareOption{dutch}{%
	\PassOptionsToPackage{dutch}{babel}
	\renewcommand{\notationname}{Notatie}%
	\renewcommand{\definitionname}{Definitie}%
	\renewcommand{\remarkname}{Opmerking}%
	\renewcommand{\examplename}{Voorbeeld}%
	\renewcommand{\conjecturename}{Vermoeden}%
	\renewcommand{\lemmaname}{Lemma}%
	\renewcommand{\theoremname}{Stelling}%
	\renewcommand{\propositionname}{Propositie}%
	\renewcommand{\corollaryname}{Gevolg}%
	\renewcommand{\proofname}{Bewijs}%
}
\DeclareOption{twosided}{\PassOptionsToPackage{twoside}{geometry}}


\DeclareOption*{\PassOptionsToClass{\CurrentOption}{book}}

%-- Execution of Options -------------------------------------------------------

\ProcessOptions*

%-- Package Loading ------------------------------------------------------------

\LoadClass{book}

\RequirePackage{calc}
\RequirePackage{ifthen}
\RequirePackage{amsmath}
\RequirePackage{geometry}
\RequirePackage{fancyhdr}

%-- Main Code ------------------------------------------------------------------

\geometry{
	a4paper,
	marginratio={2:3,2:3},
	scale={.7,.8},
	ignoreall,
	headheight=1cm
}

%>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

\pagestyle{fancy}

\lhead[\fancyplain{}{\thepage}]{\fancyplain{}{\rightmark}} \lfoot[]{}
\chead[]{} \cfoot[]{}
\rhead[\fancyplain{}{\leftmark}]{\fancyplain{}{\thepage}} \rfoot[]{}

%>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

\newcounter{unit}[section]
\setcounter{unit}{0}
\renewcommand{\theunit}{\thesection.\arabic{unit}}
\newcommand{\unitlabelstyle}{\bfseries}
\newcommand{\unitreferencestyle}{}
\newcommand{\unitname}{???}
\newcommand{\unitlabel}[1]{#1}
\newcommand{\unitclose}{}
\newcommand{\increaseunitcounter}[1][y]{%
	\ifthenelse{\equal{#1}{n}}{}{\refstepcounter{unit}}%
	\renewcommand{\unitlabel}[1]{%
		\mbox{%
			{\unitlabelstyle\unitname\ifthenelse{\equal{#1}{n}}{}{\ \theunit}}%
			\ifthenelse{\equal{##1}{}}{}{\unitreferencestyle\ (##1)}%
		}%
	}%
}%
\newcommand{\newunit}[5][y]{%
	\newenvironment{#2}[1][]{%
		\increaseunitcounter[#1]%
		\renewcommand{\unitname}{#3}%
		\renewcommand{\unitclose}{#4}%
		\begin{list}{}{%
			\renewcommand{\makelabel}{\unitlabel}%
		}\item[##1]#5%
	}{%
		\hspace*{\fill}\unitclose%
		\end{list}%
		\renewcommand{\unitname}{???}%
		\renewcommand{\unitlabel}[1]{#1}%
		\renewcommand{\unitclose}{}%
	}%
}

\newunit[n]{notation}{\notationname}{\notationend}{\notationstyle}
\newunit[n]{definition}{\definitionname}{\definitionend}{\definitionstyle}
\newunit[n]{remark}{\remarkname}{\remarkend}{\remarkstyle}
\newunit{example}{\examplename}{\exampleend}{\examplestyle}
\newunit{conjecture}{\conjecturename}{\conjectureend}{\conjecturestyle}
\newunit{lemma}{\lemmaname}{\lemmaend}{\lemmastyle}
\newunit{theorem}{\theoremname}{\theoremend}{\theoremstyle}
\newunit{proposition}{\propositionname}{\propositionend}{\propositionstyle}
\newunit{corollary}{\corollaryname}{\corollaryend}{\corollarystyle}
\newunit[n]{proof}{\proofname}{\proofend}{\proofstyle}

%>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

\newcounter{definitionlistcounter}
\newenvironment{definitionlist}[1][?]{
	\setcounter{definitionlistcounter}{0}
	\renewcommand{\thedefinitionlistcounter}{#1\arabic{definitionlistcounter}}
	\begin{list}{[\thedefinitionlistcounter]}{
		\usecounter{definitionlistcounter}
	}
}{\end{list}}

%>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

\newenvironment{summary}{
	\begin{center}
		\textbf{Summary}
	\end{center}
	\begin{list}{}{
		\setlength{\leftmargin}{20mm}
		\setlength{\rightmargin}{\leftmargin}
		\setlength{\labelwidth}{0mm}
		\setlength{\labelsep}{0mm}
		\setlength{\topsep}{0mm}
		\setlength{\itemsep}{0mm}
	}\item[]\itshape
}{\end{list}}
%>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

\newsavebox{\citationname}
\newenvironment{Citation}[1][???]{
	\sbox{\citationname}{#1}
	\begin{list}{}{
		\setlength{\leftmargin}{0.5\linewidth}
		\setlength{\rightmargin}{0mm}
		\setlength{\labelwidth}{0mm}
		\setlength{\labelsep}{0mm}
		\setlength{\topsep}{0mm}
		\setlength{\itemsep}{0mm}
	}\item[]\itshape\raggedleft
}{\end{list}\hspace*{\fill}--- \usebox{\citationname}}
