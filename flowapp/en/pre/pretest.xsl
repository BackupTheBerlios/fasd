<?xml version="1.0" encoding="ISO-8859-1"?>

<!-- 	(c) GNU General Public License
	Author: Benno Luthiger, Aktion HIP, Switzerland
-->

<!-- 
	Defining some language dependent variables, used in view
-->

<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

<xsl:variable name="dontKnow">don't know</xsl:variable>
<xsl:variable name="ButtonLbl">Save</xsl:variable>
<xsl:variable name="hoursLbl">Hours</xsl:variable>
<xsl:variable name="why1Lbl">How did you arrive at the value "</xsl:variable>
<xsl:variable name="why2Lbl">" you selected for this question?</xsl:variable>
<xsl:variable name="ownLbl">Can you explain what this question is asking? Please use your own wording.</xsl:variable>
<xsl:variable name="understandLbl">Is there something in this question you didn't understand?</xsl:variable>
<xsl:variable name="guessLbl">How sure are you of your answer: Is your declaration very precise, quite precise, rather inexact or a very rough guess?</xsl:variable>
<xsl:variable name="difficultLbl">Was this easy or hard to answer?</xsl:variable>

<xsl:variable name="TitleLbl">Pretest FASD Survey: "Fun and Software Development"</xsl:variable>
<xsl:variable name="RemarkLbl"><b>Questions concerning the FASD questionnaire:</b> This is the pretest in the true sense of the word. Please answer these questions as precise as possible. With these answers you're helping us to improve the quality of the planned survey.</xsl:variable>
<xsl:variable name="q1Lbl">I cannot say how long I've been with this job.</xsl:variable>
<xsl:variable name="q1pre_Lbl">Could you please describe what this means to you when this happens to you? What are the characteristics of such a state?</xsl:variable>
<xsl:variable name="q3Lbl">I am in a state of flow when I'm working.</xsl:variable>
<xsl:variable name="q3pre_Lbl">Could you please describe what this means to you when you're in a state of flow while working? How would you characterize such a situation?</xsl:variable>
<xsl:variable name="q5Lbl">It's easy for me to concentrate.</xsl:variable>
<xsl:variable name="q6Lbl">I'm all wrapped up in the action.</xsl:variable>
<xsl:variable name="q6pre_Lbl">Could you please describe what this means to you to be wrapped up in an action?</xsl:variable>
<xsl:variable name="q8Lbl">The requirements of my work are clear to me.</xsl:variable>
<xsl:variable name="q10Lbl">I know exactly what is required of me.</xsl:variable>
<xsl:variable name="q10pre_Lbl">Do you see a difference between these two questions?</xsl:variable>
<xsl:variable name="q11Lbl">There are many things I would prefer doing.</xsl:variable>
<xsl:variable name="q13Lbl">My work is solely motivated by the fact that it will pay for me.</xsl:variable>
<xsl:variable name="q13pre_Lbl">Could you please describe what this means to you being solely motivated by the fact that it will pay for you. Does this mean it pays financially or would you describe other consequences of your action as rewarding too? If the last holds: what results in this sense are rewarding to you?</xsl:variable>
<xsl:variable name="q21Lbl">I'm looking forward to my work.</xsl:variable>
<xsl:variable name="q29Lbl">I'm looking forward to further development activities for open source software.</xsl:variable>
<xsl:variable name="q30Lbl">I'm prepared to increase my future commitment in the development of open source software.</xsl:variable>
<xsl:variable name="q31Lbl">How often are the open source projects you work on based on a definite project vision?</xsl:variable>
<xsl:variable name="q31pre_Lbl">Could you please describe what this means to you when a project is based on a clear project vision? </xsl:variable>
<xsl:variable name="q33Lbl">How important is the vision behind an open source project for you to participate in the project?</xsl:variable>
<xsl:variable name="q35Lbl"><i>As a project member:</i> What are your reasons for participating in open source projects?</xsl:variable>
<xsl:variable name="q35aLbl">It was important for my work to have a certain functionality; that's why I joined the open source project and got involved.</xsl:variable>
<xsl:variable name="q35bLbl">My employer asked me to participate in the open source project because he needed its functionality.</xsl:variable>
<xsl:variable name="q35cLbl">Because I wanted to do something for the open source community.</xsl:variable>
<xsl:variable name="q35dLbl">The project promised to be fun.</xsl:variable>
<xsl:variable name="q35eLbl">My colleagues motivated me to participate in the open source project.</xsl:variable>
<xsl:variable name="q35fLbl">By participating in the open source project you could become famous.</xsl:variable>
<xsl:variable name="q35fpre_Lbl">Could you please describe what this means to you to become famous by participating in an open source project?</xsl:variable>
<xsl:variable name="q35gLbl">Because I wanted to learn and develop new skills.</xsl:variable>
<xsl:variable name="q36Lbl"><i>As a project leader:</i> For what reasons did you initiate your open source project(s)?</xsl:variable>
<xsl:variable name="q36aLbl">I needed a certain functionality for my work, and I wanted to make this functionality available as an open source application.</xsl:variable>
<xsl:variable name="q36bLbl">My employer asked me to start the open source project because he needed the functionality.</xsl:variable>
<xsl:variable name="q36cLbl">My employer asked me to start the open source project because he could earn money with the application.</xsl:variable>
<xsl:variable name="q36dLbl">Because I wanted to do something for the open source community.</xsl:variable>
<xsl:variable name="q36eLbl">One open source project in the past didn't develop as desired, therefore I had to start my own.</xsl:variable>
<xsl:variable name="q36fLbl">The project promised to be fun.</xsl:variable>
<xsl:variable name="q36gLbl">I needed assistants to complete a software project.</xsl:variable>
<xsl:variable name="q36hLbl">With an open source project you could become famous.</xsl:variable>
<xsl:variable name="q36pre2_Lbl">In your opinion, are there relevant reasons missing in this list?</xsl:variable>
<xsl:variable name="q37Lbl">How many patches/classes have you developed for open source software?</xsl:variable>
<xsl:variable name="q37pre_Lbl">Could you please describe what this means to you to develop a patch or a class? Do you find the question for the number of implemented patches/classes a useful measure for measuring someone's activity?</xsl:variable>
<xsl:variable name="q38Lbl">Please estimate the time you spend for the development of open source software (average hours per week).</xsl:variable>
<xsl:variable name="q39Lbl">Of the total time spent for the development of open source software, how much in percent is part of your spare time?</xsl:variable>
<xsl:variable name="q40Lbl">How much (on average, in percent) of your spare time do you spend on activities concerning open source projects?</xsl:variable>
<xsl:variable name="q41Lbl">How much of the total time (in percent) spent for the development of open source software is time that your are being paid for?</xsl:variable>
<xsl:variable name="q41pre_Lbl">What reference to question 39 do you see?</xsl:variable>
<xsl:variable name="q46Lbl">Are there other adults living in the same household with you?</xsl:variable>
<xsl:variable name="q47Lbl">How many pastimes (including programming) do you have?</xsl:variable>
<xsl:variable name="q47pre_Lbl">Could you please describe what this means to you to be periodically busy with a pastime? What are periodical pastimes for you and what do you understand under periodical?</xsl:variable>
<xsl:variable name="finishLbl">And finally:</xsl:variable>
<xsl:variable name="pre1Lbl">What's your opinion of the length of the questionnaire: Is it good, accetable, too long, too short?</xsl:variable>
<xsl:variable name="pre2Lbl">How do you judge the intelligibility of the questions?</xsl:variable>
<xsl:variable name="pre3Lbl">Are the questions you find delicate in the sense of a possible violation of privacy?</xsl:variable>
<xsl:variable name="pre4Lbl">How do you judge the design and usability of the questionnaire?</xsl:variable>

<!-- include the language independent xsl for the View -->
<xsl:include href="../../shared/pre/pretest.xsl"/>

</xsl:stylesheet>

