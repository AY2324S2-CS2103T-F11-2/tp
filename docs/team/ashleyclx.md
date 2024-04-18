---
layout: page
title: Ashley Chang's Project Portfolio Page
---

### Project: MyBookshelf

MyBookshelf - is a specialized application designed to empower community librarians by providing robust tools for efficiently managing book donations, loans, and returns. This intuitive platform enables librarians to seamlessly record, track, and organize incoming book donations, as well as efficiently manage the borrowing and returning processes. With "MyBookshelf," librarians can streamline their operations, ensuring a smoother and more organized experience for both library patrons and staff alike.

The user interacts with it using a CLI, and it has a GUI created with JavaFX. It is written in Java, and has about 10 kLoC.

Given below are my contributions to the project.

* **Book class**: Done [\#73]()
  * What it does: Book object used for library and person's borrowed list.
  * Justification: Better to have a class instead of representing books as just strings so that more attributes can be added on in the future.

* **Threshold**: Done [\#146]()
  * What it does: Acts as the limit to be compared to `MeritScore`.
  * Justification: A threshold should be abstracted out as a class instead of keeping it as a fixed variable in `BorrowCommand`.

* **Limit Command**: Done [\#146]()
  * What it does: Sets the limit to how many books a library user can borrow.
  * Justification: Since this application can be used by different people managing different libraries, there should be a function to set a limit for the library based on personal preference.

* **Code contributed**: [RepoSense link](https://nus-cs2103-ay2324s2.github.io/tp-dashboard/?search=ashleyclx&sort=groupTitle&sortWithin=title&timeframe=commit&mergegroup=&groupSelect=groupByRepos&breakdown=true&checkedFileTypes=docs~functional-code~test-code~other&since=2024-02-23&tabOpen=true&tabType=authorship&tabAuthor=ashleyclx&tabRepo=AY2324S2-CS2103T-F11-2%2Ftp%5Bmaster%5D&authorshipIsMergeGroup=false&authorshipFileTypes=docs~functional-code~test-code&authorshipIsBinaryFileTypeChecked=false&authorshipIsIgnoredFilesChecked=false)

* **Project management**:
  * Managed releases `v1.2` - `v1.3.1` (1 release) on GitHub
  * Managed tasks issues: `v1.1` - `v1.2`
  * Creation and organisation of labels

* **Enhancements to existing features**:
  * Add library functions to `Model` and `ModelManager` (Pull requests [\#146](), [\#148]())
  * Display limit when empty `limit` command typed [\#164]()

* **Documentation**:
  * User Guide:
    * Introduction section (Pull requests [\#336](), [\#342]())
    * Tutorial section [\#307]()
  * Developer Guide:
    * Added to Glossary [\#14]()
    * UML Diagram (Pull requests [\#108](), [\#324]())
    * Future Enhancements [\#269]()

* **Community**:
  * PRs reviewed (with non-trivial review comments): (Pull requests [\#66](), [\#145](), [\#147](), [\#160](), [\#174](), [\#187]())

* **Tools**:
  * Added MarkBind to documentation website: [\#179]()
