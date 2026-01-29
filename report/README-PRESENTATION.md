# Presentation Files

This directory contains the presentation materials for the Software Dependability project.

## Files

1. **`presentation.tex`** - LaTeX Beamer presentation (9 slides)
   - Professional academic format
   - Compile with: `pdflatex presentation.tex`
   - Or use Overleaf: upload `presentation.tex`

2. **`presentation-speech.md`** - Complete speech script for 3-minute presentation
   - Timed for each slide (~20-25 seconds per slide)
   - Includes tips for delivery
   - Backup information for Q&A

3. **`presentation-slides.md`** - Markdown version of slides
   - Easy to convert to PowerPoint or Google Slides
   - Can be used as reference during presentation

## How to Compile LaTeX Presentation

### Option 1: Local (if you have LaTeX installed)
```bash
cd report
pdflatex presentation.tex
# Run twice to resolve references
pdflatex presentation.tex
```

### Option 2: Overleaf (Recommended)
1. Go to https://www.overleaf.com
2. Create new project → Upload Project
3. Upload `presentation.tex`
4. Compile → Download PDF

## Presentation Structure

1. **Title Slide** (5 seconds)
2. **Introduction** (25 seconds)
3. **Project Objectives** (25 seconds)
4. **Methodology - CI/CD Pipeline** (25 seconds)
5. **Results - Test Coverage** (25 seconds)
6. **Results - Mutation Testing** (25 seconds)
7. **Formal Verification & Security** (25 seconds)
8. **Key Findings** (25 seconds)
9. **Conclusion** (20 seconds)

**Total: ~3 minutes**

## Key Points to Emphasize

- **98% test coverage** (JaCoCo)
- **70% mutation score** (PITest)
- **0 critical vulnerabilities** (Security scans)
- **All 10 evaluation criteria satisfied**
- **Automated CI/CD pipeline**

## Tips for Presentation

1. Practice the speech script multiple times
2. Time yourself to ensure ~3 minutes
3. Emphasize key numbers (98%, 70%, 0 vulnerabilities)
4. Make eye contact with the professor
5. Be confident - you've completed all requirements!

## Evidence Screenshots

Make sure to have these ready if asked:
- JaCoCo coverage report screenshot
- PITest mutation testing report screenshot
- Security scan results (dependency-check-report)
- JMH benchmark results
- CI/CD pipeline success screenshot
