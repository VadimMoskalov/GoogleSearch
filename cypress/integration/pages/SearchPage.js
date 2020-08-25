export class SearchPage {
    getSearchLine(){return cy.get("[name='q']")}
    getSearchButton(){return cy.get("[name='btnK']").eq(1)}

    open(){
        cy.visit('https://www.google.com/')
    }

    search(searchText){
        this.getSearchLine()
            .type(searchText)
            .should('have.value', 'java')

        this.getSearchButton()
            .click({force: true})
    }

}