describe('My First Test', () => {
    it('Visits the Google', () => {
        cy.visit('https://www.google.com/')

        cy.get("[name='q']")
            .type('java')
            .should('have.value', 'java')

        cy.get("[name='btnK']").eq(1)
            .click({force: true})

       cy.get("[id='logo']>img").should('be.visible')

        let count = 0
        cy.get("[class='g']").each(($el, $index, $list) => {
            let temp = $index / 2

            if ($index === 0) {
                cy.wrap($el).children("div").children("div").children("div").children("a").children("h3").should(($h) => {
                    const text = $h.text()
                    expect(text).to.contains("Java")
                })
            } else {
                cy.wrap($el).children("div").children("div").children("a").children("h3").should(($h) => {
                    let text = $h.text();

                    if (text.includes("Java")) {
                        count++;
                    }
                    expect(count).to.be.greaterThan(temp)
                })
            }
        })

    })
})